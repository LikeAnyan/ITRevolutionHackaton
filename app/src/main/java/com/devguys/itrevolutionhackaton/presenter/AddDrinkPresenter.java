package com.devguys.itrevolutionhackaton.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;
import com.devguys.itrevolutionhackaton.util.RxTransformers;
import com.devguys.itrevolutionhackaton.util.drink.DrinkFactory;
import com.devguys.itrevolutionhackaton.util.helpers.DrunkHelper;
import com.devguys.itrevolutionhackaton.view.drink.AddDrinkView;

import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sergey on 06.11.17.
 */

@InjectViewState
public class AddDrinkPresenter extends MvpPresenter<AddDrinkView>{
    private DataRepository repository;
    private PreferencesManager preferencesManager;

    @Inject
    AddDrinkPresenter(DataRepository repository, PreferencesManager preferencesManager) {
        this.repository = repository;
        this.preferencesManager = preferencesManager;
    }

    public void addDrink(double drunk, double alc, int type){
        Account account = preferencesManager.loadUserAccount();
        Drink drink = DrinkFactory.createDrink(account.getWeight(), account.getReductionCoefficient(), drunk, alc, type);
        saveDrink(drink);
    }

    private void saveDrink(Drink drink){
        repository.saveDrink(drink)
                .compose(RxTransformers.applyApiRequestSchedulers())
                .subscribe(aVoid -> getViewState().onDrinkSaved(), this::onError);
    }

    private void onError(Throwable throwable) {
        Log.e(getClass().getName(), throwable.getMessage());
        getViewState().saveDrinkFailed(throwable.getMessage());
    }
}
