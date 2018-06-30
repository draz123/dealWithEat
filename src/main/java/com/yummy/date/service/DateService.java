package com.yummy.date.service;

import com.yummy.date.model.DateResponse;
import com.yummy.date.model.DaysOfWeek;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class DateService {

    public String getDayFromDate(java.sql.Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return new DaysOfWeek().getDays().get(dayOfWeek);
    }

    public DateResponse getCurrentDateData() {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return new DateResponse("Success", 200, date.toString(), getDayFromDate(date));
    }
}
