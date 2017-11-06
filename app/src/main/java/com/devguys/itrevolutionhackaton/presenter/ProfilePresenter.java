package com.devguys.itrevolutionhackaton.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.view.profile.ProfileView;

import javax.inject.Inject;

public class ProfilePresenter extends MvpPresenter<ProfileView> {

    private DataRepository mDataRepository;
    private PreferencesManager preferencesManager;

    @Inject
    public ProfilePresenter(DataRepository repository, PreferencesManager preferencesManager) {
        this.mDataRepository = repository;
        this.preferencesManager = preferencesManager;
    }
}
