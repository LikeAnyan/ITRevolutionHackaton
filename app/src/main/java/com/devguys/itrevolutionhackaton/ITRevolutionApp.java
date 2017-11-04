package com.devguys.itrevolutionhackaton;

import android.app.Application;

import com.devguys.itrevolutionhackaton.data.DataRepositoryImpl;
import com.devguys.itrevolutionhackaton.di.ApplicationModules;
import com.devguys.itrevolutionhackaton.di.DaggerApplicationModules;
import com.devguys.itrevolutionhackaton.di.DataModule;

/**
 * Created by sergeyboy on 04.11.17.
 */

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
        applicationModules = DaggerApplicationModules.builder().dataModule(new DataModule(new DataRepositoryImpl())).build();
    }
}
