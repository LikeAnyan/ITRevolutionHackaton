package com.devguys.itrevolutionhackaton.view.login;

import com.devguys.itrevolutionhackaton.base.CoreView;

public interface LoginView extends CoreView {

    void loginSucceeded();

    void loginFailed(String message);
}
