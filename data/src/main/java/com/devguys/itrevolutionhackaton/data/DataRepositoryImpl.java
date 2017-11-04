package com.devguys.itrevolutionhackaton.data;

import com.devguys.itrevolutionhackaton.DataRepository;
import com.devguys.itrevolutionhackaton.data.factories.SessionFactory;
import com.devguys.itrevolutionhackaton.data.mapper.DataMapper;
import com.devguys.itrevolutionhackaton.data.stores.SessionStore;
import com.devguys.itrevolutionhackaton.models.Session;

import java.util.List;

import rx.Observable;

public class DataRepositoryImpl implements DataRepository {

    @Override
    public Observable<Void> saveSession(Session session) {
        SessionStore store = new SessionFactory().create();
        return store.saveSession(DataMapper.transform(session));
    }

    @Override
    public Observable<List<Session>> getSessionList() {
        SessionStore store = new SessionFactory().create();
        return store.getSessionList().map(DataMapper::transform);
    }
}
