package com.devguys.itrevolutionhackaton;

import android.app.Application;

import com.devguys.itrevolutionhackaton.data.DataRepositoryImpl;
import com.devguys.itrevolutionhackaton.di.modules.AppModule;
import com.devguys.itrevolutionhackaton.di.ApplicationModules;
import com.devguys.itrevolutionhackaton.di.DaggerApplicationModules;
import com.devguys.itrevolutionhackaton.di.modules.DataModule;
import com.devguys.itrevolutionhackaton.di.modules.PreferencesModule;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;
import com.devguys.itrevolutionhackaton.util.drink.DrinkDataset;
import com.devguys.itrevolutionhackaton.util.drink.DrinkFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeyboy on 04.11.17.
 */

public class ITRevolutionApp extends Application {
    private ApplicationModules applicationModules;
    private static ITRevolutionApp self;

    //TODO for test added account, drinks here and create objects with mock data in onCreate
    private Account account;
    private List<Drink> drinkList;

    public ITRevolutionApp(){
        self = this;
    }

    public static ITRevolutionApp get(){
        return self;
    }

    public ApplicationModules getApplicationModules() {
        return applicationModules;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationModules = DaggerApplicationModules.builder()
                .appModule(new AppModule(this))
                .preferencesModule(new PreferencesModule())
                .dataModule(new DataModule(new DataRepositoryImpl()))
                .build();

        account = new Account("Sergey Boychuk", System.currentTimeMillis(), true, 67, 0.6d, true);

        // Every 15 minutes 100 grams vodka's, start two hours ago
        long timeValue = System.currentTimeMillis() - 2 * 60000 * 60;
        drinkList = new ArrayList<>();
        drinkList.add(DrinkFactory.createDrink(account.getWeight(), account.getReductionCoefficient(), 100, 0.4, DrinkDataset.TYPE_VODKA, timeValue));
        timeValue += 15 * 60000;
        drinkList.add(DrinkFactory.createDrink(account.getWeight(), account.getReductionCoefficient(), 100, 0.4, DrinkDataset.TYPE_TEQUILA, timeValue));
        timeValue += 15 * 60000;
        drinkList.add(DrinkFactory.createDrink(account.getWeight(), account.getReductionCoefficient(), 100, 0.4, DrinkDataset.TYPE_VODKA, timeValue));
        timeValue += 15 * 60000;
        drinkList.add(DrinkFactory.createDrink(account.getWeight(), account.getReductionCoefficient(), 100, 0.4, DrinkDataset.TYPE_RUM, timeValue));
        timeValue += 15 * 60000;
        drinkList.add(DrinkFactory.createDrink(account.getWeight(), account.getReductionCoefficient(), 100, 0.4, DrinkDataset.TYPE_BEER_DARK, timeValue));
    }

    public Account getAccount() {
        return account;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }
}
