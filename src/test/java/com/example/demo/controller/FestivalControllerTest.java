package com.example.demo.controller;

import com.example.demo.Cyprusfestival;
import com.example.demo.entity.Festival;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FestivalControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;


//    @Test
//    void getFestivals() {
//        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getallfestivals", List.class).toString(), "[{festivalID=1, place=gyurt, festivalName=Portakal, festivalRunList=[{festivalRunID=1, duration=2, date=2018-03-29T13:34:00.000+00:00, festival=1, organizedFestivalRunList=[], events=[]}]}, {festivalID=2, place=gyurt, festivalName=Portakal, festivalRunList=[]}]");
//    }
//
//    @Test
//    void getFestival() {
//
//        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getfestival/1", Festival.class).toString(), "{festivalID=1, place=gyurt, festivalName=Portakal, festivalRunList=[{festivalRunID=1, duration=2, date=2018-03-29T13:34:00.000+00:00, festival=1, organizedFestivalRunList=[], events=[]}]}, {festivalID=2, place=gyurt, festivalName=Portakal, festivalRunList=[]}");
//
//    }

    @Test
    void getFestivalbyName() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getFestivalsbyname/portakal", List.class).toString(), "[{festivalID=1, place=gyurt, festivalName=Portakal, festivalRunList=[{festivalRunID=1, duration=2, date=2018-03-29T13:34:00.000+00:00, festival=1, organizedFestivalRunList=[], events=[]}]}]");
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getFestivalsbyname/CityFest", List.class).toString(), "[{festivalID=3, place=Girne, festivalName=CityFest, festivalRunList=[]}]");
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
