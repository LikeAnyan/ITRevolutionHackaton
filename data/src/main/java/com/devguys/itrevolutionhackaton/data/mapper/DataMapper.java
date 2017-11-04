package com.devguys.itrevolutionhackaton.data.mapper;

import com.devguys.itrevolutionhackaton.data.models.SessionModel;
import com.devguys.itrevolutionhackaton.models.Session;

import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static SessionModel transform(Session session) {
        return new SessionModel();
    }

    public static List<Session> transform(List<SessionModel> models) {
        return new ArrayList<>();
    }
}
