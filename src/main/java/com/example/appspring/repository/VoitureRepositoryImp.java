package com.example.appspring.repository;

import ch.qos.logback.core.model.Model;
import com.example.appspring.Entity.Modele;
import com.example.appspring.Entity.Voiture;
import com.example.appspring.repository.VoitureRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;
import  java.util.List;

public  class VoitureRepositoryImp implements VoitureRepositoryCustom {
   /* @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Voiture> ListeVoitureByModel(Modele modele){
        Query query=
                entityManager.createNativeQuery("Select v.* from Voiture v where v.modele.id = ?", Voiture.class);
        query.setParameter(1, modele.getId());

        List<Voiture> listeVoitures = query.getResultList();
        return listeVoitures;

    }*/
}
