package com.example.demo.controller;

import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import com.example.demo.service.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FestivalController {
    @Autowired
    FestivalService festivalService;

    @PostMapping("/addfestival")
    public Festival addFestival(@RequestBody Festival festival){
        return festivalService.addFestival(festival);
    }

    @GetMapping("/getfestival/{festivalid}")
    public Festival getFestival(@PathVariable long festivalID){
        return festivalService.getFestival(festivalID);
    }

    @GetMapping("/getallfestivals")
    public List<Festival> getFestivals(){
        return festivalService.getFestivals();
    }

    @GetMapping("/getfestivalsforacity/{city}")
    public List<Festival> getFestivalsForACity(@PathVariable String place){
        return festivalService.getFestivalsForACity(place);
    }

    @GetMapping("/getfestivalrun/{festivalrunid}")
    public List<FestivalRun> getFestivalRunsOfAFestival(@PathVariable long festivalID){
        return festivalService.getFestivalRunsOfAFestival(festivalID);
    }
}
