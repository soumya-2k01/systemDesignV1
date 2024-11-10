package org.example.entity;

import java.util.Date;

public class Session {
    private int id;
    private SessionType sessionType;
    private int curCapacity;
    private int maxCapacity;
    private Date startTime;
    private Date endTime;

    public Session(int sessionId, SessionType type, int cap, Date start, Date end) {
        this.id = sessionId;
        this.sessionType = type;
        this.maxCapacity = cap;
        this.startTime = start;
        this.endTime = end;
        curCapacity = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int capacity) {
        this.maxCapacity = capacity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getCurCapacity() {
        return curCapacity;
    }
    public void setCurCapacity(int curCapacity) {
        this.curCapacity = curCapacity;
    }
}
