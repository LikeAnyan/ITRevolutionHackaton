package com.devguys.itrevolutionhackaton.data.stores;

import com.devguys.itrevolutionhackaton.data.models.SessionModel;

import java.util.List;

import rx.Observable;

public interface SessionStore {

    Observable<Void> saveSession(SessionModel model);

    Observable<List<SessionModel>> getSessionList();
}
