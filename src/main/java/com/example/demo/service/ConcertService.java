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

    /**
     *
     * @param concert
     * @return  Concert
     */
    public Concert addConcert(Concert concert){
        return concertRepository.save(concert);
    }

    /**
     *
     * @param eventID
     * @return Concert
     */
    public Concert getConcert(long eventID){
        return concertRepository.findById(eventID).orElse(null);
    }

    /**
     *
     * @return  List<Concert>
     */
    public List<Concert> getConcerts(){
        return concertRepository.findAll();
    }
}
