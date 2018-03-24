package com.dwe.dealwitheat.date.service;

import com.dwe.dealwitheat.transaction.model.TakingsState;

import java.util.Calendar;

public class DateService {

    public String getDayFromDate(TakingsState type) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime() - type.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return null;
    }
}
