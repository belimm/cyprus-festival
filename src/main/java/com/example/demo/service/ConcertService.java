package com.example.demo.service;

import com.example.demo.entity.Concert;
import com.example.demo.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Concert> getConcertByDescription(String description){return concertRepository.getConcertByDescription(description);}


    public List<Concert> getLongestConcert(){
        List<Concert> concertList = new ArrayList<>();

        concertList  = concertRepository.findAll();
        Concert longestConcert = new Concert();
        String lCDuration = "0 saat";

        for(Concert c : concertList){
            String cDuration = c.getDuration();

            if(longestConcert.getDuration()==null)
                lCDuration ="0 saat";
            else
                lCDuration = longestConcert.getDuration();

            if(cDuration.compareTo(lCDuration)>=0) {
                longestConcert = c;
            }
        }
        ArrayList<Concert> longestConcerts = new ArrayList<>();

        for(Concert c:concertList) {
            if(c.getDuration().compareTo(longestConcert.getDuration())>=0) longestConcerts.add(c);
        }

        return longestConcerts;
    }

}
