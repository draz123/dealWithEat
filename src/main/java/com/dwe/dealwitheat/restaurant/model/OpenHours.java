package com.dwe.dealwitheat.restaurant.model;

public class OpenHours {

    private String openTime;
    private String closeTime;

    public OpenHours(String openTime, String closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

    public OpenHours() {
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }
}
