package com.example.demo.controller;

import com.example.demo.entity.Show;
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
    public Show addShow(@RequestBody Show show){
        return showService.addShow(show);
    }
}
