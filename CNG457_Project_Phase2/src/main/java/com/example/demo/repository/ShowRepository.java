package com.example.demo.repository;

import com.example.demo.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, long> {
}
