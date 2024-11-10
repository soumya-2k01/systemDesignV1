package org.example.entity;

public class User {
    private int id;
    private String name;

    private String authKey;

    private boolean isLoggedIn;

    private int bookingsCount;
    private Tier tier;

    public User(int id, String name, Tier tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
        this.authKey = "";
        this.isLoggedIn = false;
        this.bookingsCount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public int getBookingsCount() {
        return bookingsCount;
    }

    public void setBookingsCount(int bookingsCount) {
        this.bookingsCount = bookingsCount;
    }
}
