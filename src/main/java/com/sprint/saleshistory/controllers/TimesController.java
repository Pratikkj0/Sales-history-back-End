package com.sprint.saleshistory.controllers;

import com.sprint.saleshistory.models.TimesPojo;
import com.sprint.saleshistory.service.TimesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/times")
public class TimesController {

    private final TimesService timesService;

    @Autowired
    public TimesController(TimesService timesService) {
        this.timesService = timesService;
    }

    @GetMapping("/all")
    public List<TimesPojo> getAllTimes() {
        return timesService.getAllTimes();
    }


}
