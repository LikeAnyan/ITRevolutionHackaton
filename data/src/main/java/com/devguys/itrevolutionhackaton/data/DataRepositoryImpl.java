package com.devguys.itrevolutionhackaton.data;

import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.data.factories.UserFactory;
import com.devguys.itrevolutionhackaton.data.mapper.DataMapper;
import com.devguys.itrevolutionhackaton.data.stores.user.UserStore;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import rx.Observable;

public class DataRepositoryImpl implements DataRepository {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public DataRepositoryImpl() {
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public Observable<Account> signIn(String username, String password) {
        final UserStore store = new UserFactory(mAuth, database).create();
        return store.signIn(username, password).map(DataMapper::transform);
    }

    @Override
    public Observable<Account> signUp(String username, String password) {
        final UserStore store = new UserFactory(mAuth, database).create();
        return store.signUp(username, password).map(DataMapper::transform);
    }

    @Override
    public Observable<Account> updateAccountInfo(Account account) {
        final UserStore store = new UserFactory(mAuth, database).create();
        return store.updateAccountInfo(DataMapper.transform(account)).map(DataMapper::transform);
    }

    @Override
    public Observable<Void> logout() {
        final UserStore store = new UserFactory(mAuth, database).create();
        return store.logout();
    }

    @Override
    public Observable<Void> saveDrink(Drink drink) {
        return null;
    }

    @Override
    public Observable<List<Drink>> getDrinkList() {
        return null;
    }

    @Override
    public Observable<List<Drink>> getDrinkList(long time) {
        return null;
    }
}
