package com.devguys.itrevolutionhackaton.data.factories;

import com.devguys.itrevolutionhackaton.data.stores.drink.DrinkCloudStore;
import com.devguys.itrevolutionhackaton.data.stores.drink.DrinkStore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class DrinkFactory {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public DrinkFactory(FirebaseAuth auth, FirebaseDatabase database) {
        this.mAuth = auth;
        this.database = database;
    }

    public DrinkStore create() {
        return new DrinkCloudStore(mAuth, database);
    }
}
