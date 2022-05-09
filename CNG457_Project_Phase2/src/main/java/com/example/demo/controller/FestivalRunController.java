package com.example.demo.controller;

import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRunRepository;
import com.example.demo.service.FestivalRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FestivalRunController {
    @Autowired
    FestivalRunService festivalRunService;

    @PostMapping("/addfestivalrun")
    public FestivalRun addFestivalRun(@RequestBody FestivalRun festivalRun){
        return festivalRunService.addFestivalRun(festivalRun);
    }

    @GetMapping("/getfestivalrun/{festivalrunid}")
    public FestivalRun getFestivalRun(@PathVariable long festivalRunID){
        return festivalRunService.getFestivalRun(festivalRunID);
    }

}
