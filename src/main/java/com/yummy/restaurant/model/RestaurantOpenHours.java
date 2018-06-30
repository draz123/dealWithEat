package com.yummy.restaurant.model;

public class RestaurantOpenHours {

    private OpenHours week;
    private OpenHours sunday;
    private OpenHours saturaday;

    public RestaurantOpenHours(OpenHours week, OpenHours sunday, OpenHours saturaday) {
        this.week = week;
        this.sunday = sunday;
        this.saturaday = saturaday;
    }

    public RestaurantOpenHours() {
    }

    public OpenHours getWeek() {
        return week;
    }

    public void setWeek(OpenHours week) {
        this.week = week;
    }

    public OpenHours getSunday() {
        return sunday;
    }

    public void setSunday(OpenHours sunday) {
        this.sunday = sunday;
    }

    public OpenHours getSaturaday() {
        return saturaday;
    }

    public void setSaturaday(OpenHours saturaday) {
        this.saturaday = saturaday;
    }
}
