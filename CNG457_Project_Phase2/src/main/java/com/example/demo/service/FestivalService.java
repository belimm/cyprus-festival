package com.example.demo.service;


import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FestivalService {
    @Autowired
    FestivalRepository festivalRepository;


    public Festival addFestival(Festival festival){
        return festivalRepository.save(festival);
    }

    public Festival getFestival(long festivalID){
        return festivalRepository.findById(festivalID).orElse(null);
    }

    public List<Festival> getFestivals(){
        return festivalRepository.findAll();
    }

    /*public List<FestivalRun> getFestivalRuns(long festivalID){
        return festivalRepository.findAll();
    }*/

    public List<Festival> getFestivalsForACity(String place){
        return festivalRepository.findByplaceContains(place);
    }

}
