package com.example.demo.entity;


import lombok.Data;


import javax.persistence.Entity;

@Data
@Entity
public class Concert extends Event {
    private String performer;

}
