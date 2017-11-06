package com.devguys.itrevolutionhackaton.di;

import com.devguys.itrevolutionhackaton.LoginActivity;
import com.devguys.itrevolutionhackaton.di.modules.AppModule;
import com.devguys.itrevolutionhackaton.di.modules.DataModule;
import com.devguys.itrevolutionhackaton.di.modules.PreferencesModule;
import com.devguys.itrevolutionhackaton.view.drink.AddDrinkFragment;
import com.devguys.itrevolutionhackaton.view.fingerprint.FingerprintFragment;
import com.devguys.itrevolutionhackaton.view.login.LoginFragment;
import com.devguys.itrevolutionhackaton.view.profile.ProfileFragment;
import com.devguys.itrevolutionhackaton.view.update.CreateProfileFragment;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        DataModule.class,
        PreferencesModule.class
})
public interface ApplicationModules {

    void inject(LoginActivity loginActivity);

    void inject(LoginFragment loginFragment);

    void inject(ProfileFragment profileFragment);

    void inject(CreateProfileFragment createProfileFragment);

    void inject(AddDrinkFragment addDrinkFragment);

    void inject (FingerprintFragment fingerprintFragment);
}
