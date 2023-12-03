package com.example.appspring.Entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }



    public Long getId() {
        return id;
    }



    public Agent() {
    }


}
