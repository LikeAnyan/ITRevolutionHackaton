package com.devguys.itrevolutionhackaton.data.factories;

import com.devguys.itrevolutionhackaton.data.stores.CloudSessionStore;
import com.devguys.itrevolutionhackaton.data.stores.SessionStore;

public class SessionFactory {

    public SessionStore create() {
        return new CloudSessionStore();
    }
}
