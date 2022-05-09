package com.example.demo.service;

import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalRunService {
    @Autowired
    FestivalRunRepository festivalRunRepository;

    public FestivalRun addFestivalRun(FestivalRun festivalRun){
        return festivalRunRepository.save(festivalRun);
    }
    public FestivalRun getFestivalRun(long festivalRunID){
        return festivalRunRepository.findById(festivalRunID).orElse(null);
    }


    public List<FestivalRun> getShortFestivalRun(int duration){
        return festivalRunRepository.findBydurationLessThan(duration);
    }

}
