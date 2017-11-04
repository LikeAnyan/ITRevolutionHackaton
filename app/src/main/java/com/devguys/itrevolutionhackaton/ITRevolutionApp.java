package com.devguys.itrevolutionhackaton;

import android.app.Application;

/**
 * Created by sergeyboy on 04.11.17.
 */

public class ITRevolutionApp extends Application {
    private static ITRevolutionApp self;

    public ITRevolutionApp(){
        self = this;
    }

    public static ITRevolutionApp get(){
        return self;
    }
}
