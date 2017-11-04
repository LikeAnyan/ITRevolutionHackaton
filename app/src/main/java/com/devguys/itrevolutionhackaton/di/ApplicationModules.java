package com.devguys.itrevolutionhackaton.di;

import com.devguys.itrevolutionhackaton.view.login.LoginFragment;

import dagger.Component;

/**
 * Created by sergeyboy on 04.11.17.
 */

@Component(modules = {DataModule.class})
public interface ApplicationModules {
    void inject(LoginFragment loginFragment);
}
