package com.example.demo.controller;

import com.example.demo.entity.Showw;
import com.example.demo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowController {
    @Autowired
    ShowService showService;

    /**
     *
     * @param show
     * @return  show
     */
    @PostMapping("/addshow")
    public Showw addShow(@RequestBody Showw show){
        return showService.addShow(show);
    }

    @GetMapping("/crowdedshows")
    public List<Showw> getCrowdedShows(){
        return showService.getCrowdedShows();
    }
}
