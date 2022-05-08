package com.example.demo.repository;

import com.example.demo.entity.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival, long> {
}
