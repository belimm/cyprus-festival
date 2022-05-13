package com.example.demo.service;

import com.example.demo.entity.Organizer;
import com.example.demo.repository.OrganizerRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {
    @Autowired
    OrganizerRepository organizerRepository;

    /**
     *
     * @param organizer
     * @return  organizer
     */
    public Organizer addOrganizer(Organizer organizer){
        return organizerRepository.save(organizer);
    }

    /**
     *
     * @param organizerId
     * @return  organizer
     */
    public  Organizer getOrganizer(String organizerId){
        return organizerRepository.findById(organizerId).get();
    }


}

