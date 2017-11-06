package com.devguys.itrevolutionhackaton.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.util.RxTransformers;
import com.devguys.itrevolutionhackaton.view.login.LoginView;

import javax.inject.Inject;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {

    private DataRepository mDataRepository;
    private PreferencesManager preferencesManager;

    @Inject
    LoginPresenter(DataRepository repository, PreferencesManager preferencesManager) {
        this.mDataRepository = repository;
        this.preferencesManager = preferencesManager;
    }

    public void signIn(String username, String password){
        mDataRepository.signIn(username, password)
                .compose(RxTransformers.applyApiRequestSchedulers())
                .subscribe(this::onSuccess, this::onError);
    }

    public void signUp(String username, String password){
        mDataRepository.signUp(username, password)
                .compose(RxTransformers.applyApiRequestSchedulers())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(Account account) {
        preferencesManager.saveUserAccount(account);
        getViewState().loginSucceeded();
    }

    private void onError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
        getViewState().loginFailed(throwable.getMessage());
    }
}
