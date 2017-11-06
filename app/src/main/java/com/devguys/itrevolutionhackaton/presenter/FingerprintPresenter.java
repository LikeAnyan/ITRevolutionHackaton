package com.devguys.itrevolutionhackaton.presenter;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.util.UiUtills;
import com.devguys.itrevolutionhackaton.view.fingerprint.FingerprintView;

import javax.inject.Inject;

/**
 * Created by sergey on 06.11.17.
 */

@InjectViewState
public class FingerprintPresenter extends MvpPresenter<FingerprintView> {
    private DataRepository dataRepository;
    private FingerprintHandler fingerprintHandler;

    @Inject
    FingerprintPresenter(DataRepository dataRepository){
        this.dataRepository = dataRepository;
        this.fingerprintHandler = new FingerprintHandler();
    }

    public FingerprintHandler getFingerprintHandler(){
        return fingerprintHandler;
    }

    public void logout(){
        dataRepository.logout();
        getViewState().onLogout();
    }

    @TargetApi(23)
    public class FingerprintHandler extends FingerprintManager.AuthenticationCallback{
        private CancellationSignal cancellationSignal;
        public FingerprintHandler() {
            super();
        }

        public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject){
            cancellationSignal = new CancellationSignal();
            Context context = ITRevolutionApp.get().getApplicationContext();
            if(context.checkSelfPermission(Manifest.permission.USE_FINGERPRINT) != PackageManager.PERMISSION_GRANTED){
                getViewState().onAuthSuccess();
                return;
            }
            manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
        }

        @Override
        public void onAuthenticationError(int errorCode, CharSequence errString) {
            UiUtills.showToast(errString.toString());
        }

        @Override
        public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
            UiUtills.showToast(helpString.toString());
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
            getViewState().onAuthFailed();
        }

        @Override
        public void onAuthenticationFailed() {
            getViewState().onAuthFailed();
        }
    }
}
