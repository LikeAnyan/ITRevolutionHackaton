package com.devguys.itrevolutionhackaton.data.stores.user;

import com.devguys.itrevolutionhackaton.data.models.AccountModel;

import rx.Observable;

public interface UserStore {

    Observable<AccountModel> signIn(String username, String password);

    Observable<AccountModel> signUp(String username, String password);

    Observable<AccountModel> updateAccountInfo(AccountModel accountModel);

    Observable<Void> logout();
}
