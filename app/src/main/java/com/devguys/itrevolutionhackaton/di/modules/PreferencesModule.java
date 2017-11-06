package com.devguys.itrevolutionhackaton.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.data.PreferencesManagerImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    @Provides
    public SharedPreferences provideSharedPreferences(Application application) {
        return application.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    @Provides
    PreferencesManager provideUserManager(SharedPreferences sharedPreferences) {
        return new PreferencesManagerImpl(sharedPreferences);
    }
}
