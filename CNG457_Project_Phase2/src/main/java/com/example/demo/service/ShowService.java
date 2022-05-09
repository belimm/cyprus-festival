package com.example.demo.service;

import com.example.demo.entity.Show;
import com.example.demo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    public Show addShow(Show show){
        return showRepository.save(show);
    }

    public Show getShow(long eventID){
        return showRepository.findById(eventID).orElse(null);
    }

    public List<Show> getShows(){
        return showRepository.findAll();
    }
}
