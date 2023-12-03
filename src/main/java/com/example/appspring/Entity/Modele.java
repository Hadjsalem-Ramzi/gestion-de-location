package com.example.appspring.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "modeles")
    private Collection<Voiture> voitures;

//on peut ecrire @JsonBackReference sur @ManyToOne Voiture

    public Long getId() {
        return id;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVoitures(Collection<Voiture> voitures) {
        this.voitures = voitures;
    }



    public String getNom() {
        return nom;
    }

    public Collection<Voiture> getVoitures() {
        return voitures;
    }



    public void setId(Long id) {
        this.id = id;
    }
}