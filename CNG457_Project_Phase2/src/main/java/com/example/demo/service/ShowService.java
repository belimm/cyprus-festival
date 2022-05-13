package com.example.demo.service;

import com.example.demo.entity.Showw;
import com.example.demo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    public Showw addShow(Showw show){
        return showRepository.save(show);
    }

    public Showw getShow(long eventID){
        return showRepository.findById(eventID).orElse(null);
    }

    public List<Showw> getShows(){
        return showRepository.findAll();
    }
}
