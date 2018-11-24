package com.yummy.transaction.model;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricOrderTest {


    @Test
    public void testConvertStringToTime() {
        String date1 = "2018-02-03T14:31:48.112";
        String date2 = "2018-02-03T15:21:11.211";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime objectLocalTime = LocalDateTime.parse(date1.substring(0, 19), formatter);
        LocalDateTime comparingObjectLocalTime = LocalDateTime.parse(date2.substring(0, 19), formatter);

        assert (objectLocalTime
                .compareTo(comparingObjectLocalTime) == -1);


    }

}