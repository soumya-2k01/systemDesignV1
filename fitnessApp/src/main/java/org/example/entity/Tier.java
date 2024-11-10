package org.example.entity;

public enum Tier {
    SILVER(3), GOLD(5), PLATINUM(10);

    private final int limit ;

    Tier(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
