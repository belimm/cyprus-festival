package com.example.demo.service;

import com.example.demo.entity.Concert;
import com.example.demo.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {
    @Autowired
    ConcertRepository concertRepository;

    public Concert addConcert(Concert concert){
        return concertRepository.save(concert);
    }

    public Concert getConcert(long eventID){
        return concertRepository.findById(eventID).orElse(null);
    }

    public List<Concert> getConcerts(){
        return concertRepository.findAll();
    }
}
