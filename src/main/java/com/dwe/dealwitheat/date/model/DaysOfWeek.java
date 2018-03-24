package com.dwe.dealwitheat.date.model;

import java.util.HashMap;
import java.util.Map;

public class DaysOfWeek {

    public DaysOfWeek() {
        days = new HashMap<>();
        days.put(0, "Poniedziałek");
        days.put(1, "Wtorek");
        days.put(2, "Środa");
        days.put(3, "Czwartek");
        days.put(4, "Piątek");
        days.put(5, "Sobota");
        days.put(6, "Niedziela");

    }

    private Map<Integer, String> days;

    public Map<Integer, String> getDays() {
        return days;
    }

    public void setDays(Map<Integer, String> days) {
        this.days = days;
    }
}
