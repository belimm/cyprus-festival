package com.example.demo.controller;


import com.example.demo.Cyprusfestival;
import com.example.demo.entity.Organizer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Cyprusfestival.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrganizerControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    int port;


    @Test
    void getOrganizer(){
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getorganiser/irfanalgnan@gmail.com", Organizer.class).toString(), "Organizer(email=irfanalgnan@gmail.com, phoneNo=8801380, name=irfan, surname=algan)");
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getorganiser/sezgin.mamu@gmail.com", Organizer.class).toString(), "Organizer(email=sezgin.mamu@gmail.com, phoneNo=8801380, name=mahmut, surname=sezgin)");
        assertEquals(this.restTemplate.getForObject("http://localhost:" + port + "/getorganiser/limoncu.berk@gmail.com", Organizer.class).toString(), "Organizer(email=limoncu.berk@gmail.com, phoneNo=8801380, name=berk, surname=limoncu)");

    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
