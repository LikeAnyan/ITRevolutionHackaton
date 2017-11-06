package com.devguys.itrevolutionhackaton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.devguys.itrevolutionhackaton.base.BaseActivity;
import com.devguys.itrevolutionhackaton.view.drink.AddDrinkFragment;
import com.devguys.itrevolutionhackaton.view.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    static final String EXTRA_ADD_DRINK = "extra_add_drink";

    public static void openAddDrink(Activity activity){
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra(EXTRA_ADD_DRINK, true);
        activity.startActivity(intent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getIntent().getBooleanExtra(EXTRA_ADD_DRINK, false)){
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new AddDrinkFragment())
                    .commit();
            return;
        }

        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new ProfileFragment()).commit();
    }
}
