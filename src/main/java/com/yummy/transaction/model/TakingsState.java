package com.yummy.transaction.model;

public enum TakingsState {
    ENTIRE(0L), MONTHLY(2592000000L), WEEKLY(604800000L);

    long time;

    public long getTime() {
        return time;
    }

    TakingsState(long l) {
        this.time=l;
    }
}
