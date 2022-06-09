package com.example.demo.repository;

import com.example.demo.entity.Concert;
import com.example.demo.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, String> {
    public List<Organizer> findByEmailStartingWithOrNameOrPhoneNoOrSurname(String email,String name,int phoneNo,String surname);

    @Query(value =
            "SELECT * FROM Organizer " +
            "WHERE  Organizer.email " +
            "IN(" +
                "SELECT email FROM " +
                    "(SELECT email,COUNT(*) " +
                    "FROM OrganizedFestivalRun " +
                    "GROUP by email " +
                    "HAVING count(*)>1) " +
                    "AS Counter );",nativeQuery = true)
    public  List<Organizer> getListOfOrganizerWhoOrganizedMultipleFRuns();
}
