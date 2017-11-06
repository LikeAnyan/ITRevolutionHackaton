package com.devguys.itrevolutionhackaton.data.stores.user;

import com.devguys.itrevolutionhackaton.data.models.AccountModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import rx.Observable;

public class UserCloudStore implements UserStore {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public UserCloudStore(FirebaseAuth auth, FirebaseDatabase database) {
        this.mAuth = auth;
        this.database = database;
    }

    @Override
    public Observable<AccountModel> signIn(String username, String password) {
        return Observable.create(subscriber -> mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                subscriber.onNext(getAccountFromCloud());
                subscriber.onCompleted();
            } else {
                subscriber.onError(task.getException());
            }
        }));
    }

    @Override
    public Observable<AccountModel> signUp(String username, String password) {
        return Observable.create(subscriber -> mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                subscriber.onNext(getAccountFromCloud());
                subscriber.onCompleted();
            } else {
                subscriber.onError(task.getException());
            }
        }));
    }

    @Override
    public Observable<Void> logout() {
        mAuth.signOut();
        return Observable.just(null);
    }

    private AccountModel getAccountFromCloud() {
        return null;
    }
}
