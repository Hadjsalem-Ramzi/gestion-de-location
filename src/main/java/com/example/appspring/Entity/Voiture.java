package com.example.appspring.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;


@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serie;
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_Mise_En_Marche;

    public Date getDate_Mise_En_Marche() {
        return date_Mise_En_Marche;
    }


    public Long getId(){
        return id;
    }

  @OneToMany(mappedBy = "voiture")
  private Collection<Location> locations ;

    @ManyToOne
    private Modele modeles;
    public Modele getModeles() {
        return modeles;
    }

    public String getSerie() {
        return serie;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setDate_Mise_En_Marche(Date date_Mise_En_Marche) {
        this.date_Mise_En_Marche = date_Mise_En_Marche;
    }



    public void setModeles(Modele modeles) {
        this.modeles = modeles;
    }
}
