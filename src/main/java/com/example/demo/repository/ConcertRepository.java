package com.example.demo.repository;

import com.example.demo.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

   @Query("SELECT c FROM Concert c WHERE c.description LIKE %?1%")
    public List<Concert> getConcertByDescription(String description);

}
