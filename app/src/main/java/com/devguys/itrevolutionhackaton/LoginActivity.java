package com.devguys.itrevolutionhackaton;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.devguys.itrevolutionhackaton.base.BaseActivity;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.util.UiUtills;
import com.devguys.itrevolutionhackaton.view.login.LoginFragment;
import com.devguys.itrevolutionhackaton.view.update.CreateProfileFragment;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    public static final String EXTRA_SUCCES_FINGERPRINT = "success_fingerprint";

    @Inject
    PreferencesManager preferencesManager;
    static final String EXTRA_EDIT_PROFILE = "extra_edit_profile";

    public static void openAccountEdit(Activity activity){
        Intent intent = new Intent(activity, LoginActivity.class);
        intent.putExtra(EXTRA_EDIT_PROFILE, true);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ITRevolutionApp.get().getApplicationModules().inject(this);

        if(getIntent().getBooleanExtra(EXTRA_EDIT_PROFILE, false)){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new CreateProfileFragment())
                    .commit();
            return;
        }

        Account account = preferencesManager.loadUserAccount();
        if(account != null) {
            if(account.isUseDevicesFingerprint() && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                FingerprintManager fingerprintManager = (FingerprintManager) getSystemService(FINGERPRINT_SERVICE);
                KeyguardManager keyguardManager = (KeyguardManager) getSystemService(KEYGUARD_SERVICE);
                if(fingerprintManager.isHardwareDetected()){
                    if(!fingerprintManager.hasEnrolledFingerprints() || !keyguardManager.isKeyguardSecure()){
                        UiUtills.showToast(R.string.fingerprint_no_scans);
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        return;
                    }
                } else{
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            } else{
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        } else if(preferencesManager.loadUserAccount() == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new LoginFragment())
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new CreateProfileFragment())
                    .commit();
        }
    }
}
