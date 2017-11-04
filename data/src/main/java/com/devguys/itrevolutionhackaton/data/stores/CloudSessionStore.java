package com.devguys.itrevolutionhackaton.data.stores;

import com.devguys.itrevolutionhackaton.data.models.SessionModel;

import java.util.List;

import rx.Observable;

public class CloudSessionStore implements SessionStore {
    @Override
    public Observable<Void> saveSession(SessionModel model) {
        return null;
    }

    @Override
    public Observable<List<SessionModel>> getSessionList() {
        return null;
    }
}
