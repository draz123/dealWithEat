package com.dwe.dealwitheat.date.model;

import java.util.HashMap;
import java.util.Map;

public class DaysOfWeek {

    public DaysOfWeek() {
        days = new HashMap<>();
        days.put(2, "Poniedziałek");
        days.put(4, "Wtorek");
        days.put(4, "Środa");
        days.put(5, "Czwartek");
        days.put(6, "Piątek");
        days.put(7, "Sobota");
        days.put(1, "Niedziela");

    }

    private Map<Integer, String> days;

    public Map<Integer, String> getDays() {
        return days;
    }

    public void setDays(Map<Integer, String> days) {
        this.days = days;
    }
}
