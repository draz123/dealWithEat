package com.dwe.dealwitheat.date.model;

public class DateResponse {

    private String date;
    private String day;

    public DateResponse(String date, String day) {
        this.date = date;
        this.day = day;
    }

    public DateResponse() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
