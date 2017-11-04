package com.devguys.itrevolutionhackaton;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.devguys.itrevolutionhackaton.base.BaseActivity;
import com.devguys.itrevolutionhackaton.view.login.LoginFragment;

/**
 * Created by sergeyboy on 04.11.17.
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginFragment loginFragment = new LoginFragment();
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, loginFragment).commit();
    }
}
