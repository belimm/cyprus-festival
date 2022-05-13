package com.example.demo.repository;

import com.example.demo.entity.Festival;
import com.example.demo.entity.FestivalRun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
    public List<Festival> findByplaceContains(String place);
}


