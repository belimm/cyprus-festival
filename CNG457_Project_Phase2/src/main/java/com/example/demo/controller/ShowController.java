package com.example.demo.controller;

import com.example.demo.entity.Showw;
import com.example.demo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/addshow")
    public Showw addShow(@RequestBody Showw show){
        return showService.addShow(show);
    }
}
