package com.example.demo.controller;

import com.example.demo.Cyprusfestival;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShowControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Test
    void getCrowdedShows(){
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/crowdedshows", List.class).toString(), "[{eventID=2, eventName=Kahkahayla tufan, date=2022-03-29T13:34:00.000+00:00, duration=2.0, description=aciklama yok, festivalRun=null, performers=[]}, {eventID=3, eventName=Burada Laf Çok, date=2022-03-29T13:34:00.000+00:00, duration=2.0, description=aciklama yok, festivalRun=null, performers=[]}]");

    }

}
