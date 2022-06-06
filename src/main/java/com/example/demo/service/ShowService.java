package com.example.demo.service;

import com.example.demo.entity.Showw;
import com.example.demo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;

    /**
     *
     * @param show
     * @return  true if the show is added successfully
     */
    public Showw addShow(Showw show){
        return showRepository.save(show);
    }

    /**
     *
     * @param eventID
     * @return  the show with the given eventID
     */
    public Showw getShow(long eventID){
        return showRepository.findById(eventID).orElse(null);
    }

    /**
     *
     * @return  all the shows
     */
    public List<Showw> getShows(){
        return showRepository.findAll();
    }

    public List<Showw> getCrowdedShows(){
        List<Showw> allShows = showRepository.findAll();
        int crowded = 0;

        for(Showw s : allShows){

            if(s.getPerformers().size()>crowded)
                crowded = s.getPerformers().size();
        }

        ArrayList<Showw> crowdedShows = new ArrayList<>();
        for(Showw s : allShows){
            if(s.getPerformers().size()==crowded)
                crowdedShows.add(s);
        }

        return crowdedShows;

    }
}
