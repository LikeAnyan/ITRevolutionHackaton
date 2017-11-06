package com.devguys.itrevolutionhackaton.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.view.profile.ProfileView;

import javax.inject.Inject;

/**
 * Created by sergey on 05.11.17.
 */

public class ProfilePresenter extends MvpPresenter<ProfileView> {
    private DataRepository mDataRepository;

    @Inject
    public ProfilePresenter(DataRepository repository) {
        this.mDataRepository = repository;
    }
}
