package com.yummy.date.controller;

import com.yummy.commons.Response;
import com.yummy.date.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {

    @Autowired
    private DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping(value = "date")
    private Response getDateData() {
        return dateService.getCurrentDateData();
    }
}
