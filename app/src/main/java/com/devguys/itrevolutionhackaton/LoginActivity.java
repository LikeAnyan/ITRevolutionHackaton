package com.devguys.itrevolutionhackaton;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.devguys.itrevolutionhackaton.base.BaseActivity;
import com.devguys.itrevolutionhackaton.view.login.LoginFragment;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity {

    @Inject
    PreferencesManager preferencesManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ITRevolutionApp.get().getApplicationModules().inject(this);

        if(preferencesManager.loadUserAccount() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, new LoginFragment())
                    .commit();
        }
    }
}
