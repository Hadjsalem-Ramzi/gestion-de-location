package com.example.appspring.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date date_debut;
    private Date date_retour;
    private Long prix_jour;
    private Long prix;

    public void setId(Long id) {
        this.id = id;
    }
  @ManyToOne
   private Client client;

    @ManyToOne
    private  Voiture voiture;
    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public void setPrix_jour(Long prix_jour) {
        this.prix_jour = prix_jour;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public Long getPrix_jour() {
        return prix_jour;
    }

    public Long getPrix() {
        return prix;
    }

    public Location() {
    }

    public Location(Date date_debut, Date date_retour, Long prix_jour, Long prix) {
        this.date_debut = date_debut;
        this.date_retour = date_retour;
        this.prix_jour = prix_jour;
        this.prix = prix;
    }
}
