package com.dwe.dealwitheat.date.model;

import com.dwe.dealwitheat.commons.Response;

public class DateResponse extends Response {

    private String date;
    private String day;


    public DateResponse(String message, int code, String date, String day) {
        super(message, code);
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
