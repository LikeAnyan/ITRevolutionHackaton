package com.devguys.itrevolutionhackaton.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;
import com.devguys.itrevolutionhackaton.util.RxTransformers;
import com.devguys.itrevolutionhackaton.view.profile.ProfileView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {

    private DataRepository mDataRepository;
    private PreferencesManager preferencesManager;

    @Inject
    public ProfilePresenter(DataRepository repository, PreferencesManager preferencesManager) {
        this.mDataRepository = repository;
        this.preferencesManager = preferencesManager;
    }

    public Account getProfile() {
        return preferencesManager.loadUserAccount();
    }

    public void getAllDrinks(long time) {
        mDataRepository.getDrinkList(time)
                .compose(RxTransformers.applyApiRequestSchedulers())
                .subscribe(getViewState()::updateBloodLevel, this::onError);
    }

    public void getAllDrinks() {
        mDataRepository.getDrinkList()
                .compose(RxTransformers.applyApiRequestSchedulers())
                .subscribe(getViewState()::updateStatistic, this::onError);
    }

    private void onError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
    }
}
