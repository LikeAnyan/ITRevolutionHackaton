package com.devguys.itrevolutionhackaton;

import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Session;

import java.util.List;

import rx.Observable;

public interface DataRepository {
    //TODO Session remove
    //TODO не забудь будь ласка про два метода отримання даних, перший - без параметрів, який повертає всі дані, а другий з long time, який повертає дані для яких виконується умова time < endTime;

    Observable<Account> login(String username, String password);

    Observable<Void> saveSession(Session session);

    Observable<List<Session>> getSessionList();
}
