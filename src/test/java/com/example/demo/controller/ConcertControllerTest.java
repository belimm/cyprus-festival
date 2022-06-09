package com.example.demo.controller;


import com.example.demo.Cyprusfestival;
import com.example.demo.entity.Concert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConcertControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void getConcertsByDescription() {
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getconcertsbydescription/aciklama", List.class).toString(), "[{eventID=1, eventName=Fikri Konser, date=2022-05-29T13:34:00.000+00:00, duration=3.0, description=aciklama, festivalRun=null, performer=Fikri Karayel}]".toString());
    }

    @Test
    void getLongestConcert(){
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/longestconcerts", List.class).toString(), "[{eventID=1, eventName=Fikri Konser, date=2022-05-29T13:34:00.000+00:00, duration=3.0, description=aciklama, festivalRun=null, performer=Fikri Karayel}, {eventID=4, eventName=Nafiz Dölek Konser, date=2022-06-29T13:34:00.000+00:00, duration=3.0, description=aciklama, festivalRun=null, performer=Nafiz Dölek}]".toString());
    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}

