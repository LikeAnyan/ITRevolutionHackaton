package com.devguys.itrevolutionhackaton;

import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Session;

import java.util.List;

import rx.Observable;

public interface DataRepository {

    Observable<Account> login(String username, String password);

    Observable<Void> saveSession(Session session);

    Observable<List<Session>> getSessionList();
}
