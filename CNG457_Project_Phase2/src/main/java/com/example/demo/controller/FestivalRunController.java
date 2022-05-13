package com.example.demo.controller;

import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRunRepository;
import com.example.demo.service.FestivalRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FestivalRunController {
    @Autowired
    FestivalRunService festivalRunService;

    @PostMapping("/addfestivalrun")
    public FestivalRun addFestivalRun(@RequestBody FestivalRun festivalRun){
        return festivalRunService.addFestivalRun(festivalRun);
    }

    @GetMapping("/getfestivalrun/{festivalRunID}")
    public FestivalRun getFestivalRun(@PathVariable long festivalRunID){
        return festivalRunService.getFestivalRun(festivalRunID);
    }

    @GetMapping("/getshortfestivalrun/{duration}")
    public List<FestivalRun> getShortFestivalRun(@PathVariable int duration){
        return festivalRunService.getShortFestivalRun(duration);
    }


}
