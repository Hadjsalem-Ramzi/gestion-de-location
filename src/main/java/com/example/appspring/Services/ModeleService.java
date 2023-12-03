package com.example.appspring.Services;

import com.example.appspring.Entity.Client;
import com.example.appspring.Entity.Modele;

import java.util.List;

public interface ModeleService {
    List<Modele> getAllModele();
    Modele createModele(Modele modele);

    Modele getModeleByID(Long id);
    Modele updateModele(Modele modele);

    void deleteModele(Long id);
}
