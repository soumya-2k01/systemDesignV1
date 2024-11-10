package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.entity.Session;
import org.example.entity.SessionType;

public class AdminService {
    List<Session> sessions;

    public AdminService() {
        sessions = new ArrayList<>();
    }

    public void createSession(Session session) {
        sessions.add(session);
    }

    public List<Session> getSessionsByType(SessionType sessionType) {
        return sessions.stream().filter(session -> session.getSessionType().equals(sessionType)).collect(Collectors.toList());
    }

    public void validateSessionEligibility(Session session) {
        if(!sessions.stream().filter(sess -> sess.getId() == session.getId()).findFirst().isPresent()) {
            throw new RuntimeException("This session is not present");
        }
    }

}
