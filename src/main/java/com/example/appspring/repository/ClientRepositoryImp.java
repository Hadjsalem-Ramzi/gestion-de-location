package com.example.appspring.repository;

import com.example.appspring.Entity.Client;
import com.example.appspring.repository.ClientRepositoryCostum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class ClientRepositoryImp implements ClientRepositoryCostum {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Client getClientByNom(String nom){
        Query query=entityManager.createNativeQuery("select C.* FROM Client C"+"WERE C.nom Like ?",Client.class );
        query.setParameter(1,nom+"%");
        return (Client) query.getSingleResult();
    }
}
