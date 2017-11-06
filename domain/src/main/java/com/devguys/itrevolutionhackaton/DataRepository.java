package com.devguys.itrevolutionhackaton;

import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;

import java.util.List;

import rx.Observable;

public interface DataRepository {

    Observable<Account> signIn(String username, String password);

    Observable<Account> signUp(String username, String password);

    Observable<Account> updateAccountInfo(Account account);

    Observable<Void> logout();

    Observable<Void> saveDrink(Drink drink);

    Observable<List<Drink>> getDrinkList();

    Observable<List<Drink>> getDrinkList(long time);
}
