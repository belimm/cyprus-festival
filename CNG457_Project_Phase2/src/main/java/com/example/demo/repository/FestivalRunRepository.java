package com.example.demo.repository;

import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalRunRepository extends JpaRepository<FestivalRun, long> {
    public List<FestivalRun> findBydurationLessThan(int duration);
    public List<FestivalRun> findByContains(long festivalID);

}
