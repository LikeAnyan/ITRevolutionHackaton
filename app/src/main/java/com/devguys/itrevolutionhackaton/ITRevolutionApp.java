package com.devguys.itrevolutionhackaton;

import android.app.Application;

import com.devguys.itrevolutionhackaton.data.DataRepositoryImpl;
import com.devguys.itrevolutionhackaton.di.modules.AppModule;
import com.devguys.itrevolutionhackaton.di.ApplicationModules;
import com.devguys.itrevolutionhackaton.di.DaggerApplicationModules;
import com.devguys.itrevolutionhackaton.di.modules.DataModule;
import com.devguys.itrevolutionhackaton.di.modules.PreferencesModule;

public class ITRevolutionApp extends Application {

    private ApplicationModules applicationModules;
    private static ITRevolutionApp self;

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
    }
}
