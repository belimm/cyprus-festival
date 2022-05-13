package com.example.demo.repository;

import com.example.demo.entity.Showw;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Showw, Long> {
}
