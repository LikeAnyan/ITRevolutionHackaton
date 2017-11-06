package com.devguys.itrevolutionhackaton.view.login;

import com.devguys.itrevolutionhackaton.base.CoreView;

public interface LoginView extends CoreView {

    void signInSucceeded();

    void signUpSucceeded();

    void loginFailed(String message);
}
