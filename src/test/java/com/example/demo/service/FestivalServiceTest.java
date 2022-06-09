package com.example.demo.service;

import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import com.example.demo.repository.FestivalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FestivalServiceTest {
    @InjectMocks
    FestivalService festivalService;

    @Mock
    FestivalRepository festivalRepository;

    @Test
    void getFestivals(){
        ArrayList<Festival> festivals = new ArrayList<>();
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"lefke","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));

        when(festivalRepository.findAll()).thenReturn(festivals);

        List<Festival> festivalList = festivalService.getFestivals();
        Assertions.assertEquals(festivals.size(),festivalList.size());
        Assertions.assertEquals("girne",festivalList.get(0).getPlace());
    }

    @Test
    void getFestival(){
        List<Festival> festivals = new ArrayList<>();
        Festival festival;
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"lefke","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));
        long festivalID = 1;

        doReturn(Optional.of(festivals.get(0))).when(festivalRepository).findById(festivalID);

        festival = festivalService.getFestival(festivalID);
        Assertions.assertEquals(festivals.get(0).getPlace(),festival.getPlace());
        Assertions.assertEquals(festivals.get(0).getFestivalName(),festival.getFestivalName());
        Assertions.assertEquals(festival,festivals.get(0));

    }
    @Test
    void getFestivalsForACity(){
        /***********************************************************************************************************************/
        ArrayList<Festival> festivals = new ArrayList<>();
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"girne","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));
        String place = "lefke";


        when(festivalRepository.findByplaceContains(place)).thenReturn(festivals);
        List<Festival> festivalList = festivalService.getFestivalsForACity(place);
        System.out.println(festivalList);
        Assertions.assertEquals(festivals.size(),festivalList.size());
        Assertions.assertEquals("girne",festivalList.get(0).getPlace());

    }

    @Test
    void getFestivalbyName(){
        List<Festival> festivals = new ArrayList<>();
        Festival festival;
        festivals.add(new Festival(1,"girne","portakal",null));
        festivals.add(new Festival(2,"lefke","elma",null));
        festivals.add(new Festival(3,"gyurt","limon",null));
        String festivalName = "portakal";

        when(festivalRepository.getFestivalByName(festivalName)).thenReturn(festivals);


        List<Festival> festivalList = festivalService.getFestivalbyName(festivalName);
        System.out.println(festivalList);
        Assertions.assertEquals(festivals.size(),festivalList.size());
        Assertions.assertEquals("portakal",festivalList.get(0).getFestivalName());

    }

    @Test
    void getFestivalRunsOfAFestival(){

        ArrayList<Festival> festivals = new ArrayList<>();
       Festival festival = new Festival();
       List<FestivalRun> festivalRunList = new ArrayList<>();

       FestivalRun festivalRun1 = new FestivalRun();
       FestivalRun festivalRun2 = new FestivalRun();

       festivalRun1.setFestivalRunID(1);
       festivalRun1.setDuration(3);
       festivalRun1.setDate(null);

        festivalRun1.setFestivalRunID(2);
        festivalRun1.setDuration(6);
        festivalRun1.setDate(null);


       festivalRunList.add(festivalRun1);
       festivalRunList.add(festivalRun2);

       festivals.add(festival);

       festival.setFestivalID(1);
       festival.setFestivalRunList(festivalRunList);
       festival.setPlace("Güzelyurt");
       festival.setPlace("Portakal Festivali");

       long festivalID =1;

        doReturn(Optional.of(festival)).when(festivalRepository).findById(festivalID);


        //when(festivalRepository.findById(festivalID)).thenReturn(festival);
        try{
            //doReturn(Optional.of(festival)).when(festivalRepository).findById(festivalID);
            when(festivalRepository.findById(festivalID).get().getFestivalRunList()).thenReturn(festivalRunList);
        }
        catch (Exception e){
            
        }


        //doReturn(Optional.of(festival)).when(festivalRepository).findById(festivalID).orElse(null).getFestivalRunList();


    }

}
