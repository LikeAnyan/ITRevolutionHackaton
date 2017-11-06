package com.devguys.itrevolutionhackaton.data.stores.user;

import com.devguys.itrevolutionhackaton.data.models.AccountModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

public class UserCloudStore implements UserStore {

    private FirebaseAuth mAuth;
    private DatabaseReference database;

    public UserCloudStore(FirebaseAuth auth, FirebaseDatabase database) {
        this.mAuth = auth;
        this.database = database.getReference();
    }

    @Override
    public Observable<AccountModel> signIn(String username, String password) {
        return Observable.create(subscriber -> mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
            if(task.isSuccessful() && mAuth.getCurrentUser() != null) {
                subscriber.onNext(getAccountFromCloud(mAuth.getCurrentUser().getUid()));
                subscriber.onCompleted();
            } else {
                subscriber.onError(task.getException());
            }
        }));
    }

    @Override
    public Observable<AccountModel> signUp(String username, String password) {
        return Observable.create(subscriber -> mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
            if(task.isSuccessful() && mAuth.getCurrentUser() != null) {
                database.child("users").push().setValue(mAuth.getCurrentUser().getUid());
                database.child("drinks").push().setValue(mAuth.getCurrentUser().getUid());

                subscriber.onNext(new AccountModel());
                subscriber.onCompleted();
            } else {
                subscriber.onError(task.getException());
            }
        }));
    }

    @Override
    public Observable<AccountModel> updateAccountInfo(AccountModel accountModel) {
        return Observable.create(subscriber -> {
            if(mAuth.getCurrentUser() != null) {
                Map<String, Object> details = new HashMap<>();
                details.put("userName", accountModel.getUserName());
                details.put("avatar", accountModel.getAvatar());
                details.put("birthday", accountModel.getBirthday());
                details.put("male", accountModel.isMale());
                details.put("weight", accountModel.getWeight());

                // update cloud
                DatabaseReference userRef = database.child("users").child(mAuth.getCurrentUser().getUid());
                userRef.updateChildren(details);

                // update UI
                subscriber.onNext(accountModel);
                subscriber.onCompleted();
            } else subscriber.onError(new Throwable("You don't sign in!"));
        });
    }

    @Override
    public Observable<Void> logout() {
        mAuth.signOut();
        return Observable.just(null);
    }

    private AccountModel getAccountFromCloud(String uuid) {
        return null;
    }
}
