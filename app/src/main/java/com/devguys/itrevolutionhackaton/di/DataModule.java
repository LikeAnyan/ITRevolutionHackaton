package com.devguys.itrevolutionhackaton.di;

import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.data.DataRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sergeyboy on 04.11.17.
 */

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
