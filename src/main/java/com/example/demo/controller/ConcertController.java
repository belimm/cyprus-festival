package com.example.demo.controller;

import com.example.demo.entity.Concert;
import com.example.demo.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConcertController {
    @Autowired
    ConcertService concertService;

    /**
     *
     * @param concert
     * @return  Concert
     */
    @PostMapping("/addconcert")
    public Concert addConcert(@RequestBody Concert concert){
        return concertService.addConcert(concert);
    }
}
