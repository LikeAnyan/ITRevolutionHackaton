package com.devguys.itrevolutionhackaton.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.util.RxTransformers;
import com.devguys.itrevolutionhackaton.util.helpers.DrunkHelper;
import com.devguys.itrevolutionhackaton.view.update.CreateProfileView;

import javax.inject.Inject;

@InjectViewState
public class CreateProfilePresenter extends MvpPresenter<CreateProfileView> {

    private DataRepository repository;
    private PreferencesManager preferencesManager;

    @Inject
    CreateProfilePresenter(DataRepository repository, PreferencesManager preferencesManager) {
        this.repository = repository;
        this.preferencesManager = preferencesManager;
    }

    public Account getProfile() {
        return preferencesManager.loadUserAccount();
    }

    private void updateProfile(Account account) {
        repository.updateAccountInfo(account)
                .doOnNext(accountInfo -> preferencesManager.saveUserAccount(account))
                .compose(RxTransformers.applyApiRequestSchedulers())
                .subscribe(accountInfo -> getViewState().updateProfileSucceeded(), this::onError);
    }

    public void updateProfile(String userName, long birthday, boolean isMale, double weight, boolean useFinger){
        Account account = getProfile();
        account.setUserName(userName);
        account.setBirthday(birthday);
        account.setMale(isMale);
        account.setWeight(weight);
        account.setReductionCoefficient(DrunkHelper.getReductionCoefficient(isMale, birthday));
        account.setUseDevicesFingerprint(useFinger);
        updateProfile(account);
    }

    private void onError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
        getViewState().updateProfileFailed(throwable.getMessage());
    }
}
