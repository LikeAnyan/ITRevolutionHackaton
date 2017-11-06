package com.devguys.itrevolutionhackaton.di.modules;

import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.data.DataRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    private DataRepository mDataRepository;

    public DataModule(DataRepository dataRepository) {
        this.mDataRepository = dataRepository;
    }

    @Provides
    DataRepository provideDataRepository(){
        return mDataRepository;
    }
}
