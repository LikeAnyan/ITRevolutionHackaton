package com.devguys.itrevolutionhackaton;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.devguys.itrevolutionhackaton.base.BaseActivity;
import com.devguys.itrevolutionhackaton.view.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProfileFragment profileFragment = new ProfileFragment();
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, profileFragment).commit();
    }
}
