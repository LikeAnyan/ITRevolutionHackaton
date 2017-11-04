package com.devguys.itrevolutionhackaton;

import com.devguys.itrevolutionhackaton.models.Session;

import java.util.List;

import rx.Observable;

public interface DataRepository {

    Observable<Void> saveSession(Session session);

    Observable<List<Session>> getSessionList();
}
