package com.devguys.itrevolutionhackaton.data.factories;

import com.devguys.itrevolutionhackaton.data.stores.user.UserCloudStore;
import com.devguys.itrevolutionhackaton.data.stores.user.UserStore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class UserFactory {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public UserFactory(FirebaseAuth auth, FirebaseDatabase database) {
        this.mAuth = auth;
        this.database = database;
    }

    public UserStore create() {
        return new UserCloudStore(mAuth, database);
    }
}
