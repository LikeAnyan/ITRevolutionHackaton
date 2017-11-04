package com.devguys.itrevolutionhackaton.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.view.login.LoginView;

import javax.inject.Inject;

/**
 * Created by sergeyboy on 04.11.17.
 */

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    public DataRepository mDataRepository;

    @Inject
    public LoginPresenter(DataRepository repository) {
        getViewState().onButtonPressed("test");
        this.mDataRepository = repository;
    }

    public void onBtnPressed(){
        Log.e(getClass().getName(), String.valueOf(mDataRepository != null));
        getViewState().onButtonPressed("onBtnPressed");
    }
}
