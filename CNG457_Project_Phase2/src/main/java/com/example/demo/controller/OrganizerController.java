package com.example.demo.controller;

import com.example.demo.entity.Organizer;
import com.example.demo.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;

    @PostMapping("/addorganiser")
    public Organizer addOrganizer(@RequestBody Organizer organizer){
        return organizerService.addOrganizer(organizer);
    }

    @GetMapping("/getorganiser/{email}")
    public Organizer getOrganizer(@PathVariable String email){
        return organizerService.getOrganizer(email);
    }
}



