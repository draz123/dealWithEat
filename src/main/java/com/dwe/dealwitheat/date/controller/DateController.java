package com.dwe.dealwitheat.date.controller;

import com.dwe.dealwitheat.date.model.DateResponse;
import com.dwe.dealwitheat.date.service.DateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateController {


    private ObjectMapper mapper;

    public DateController() {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Autowired
    private DateService dateService;

    @GetMapping(value = "date")
    private String getDateData() {
        DateResponse response = dateService.getCurrentDateData();
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            return "[]";
        }
    }
}
