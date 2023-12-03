package com.example.appspring.Services;

import com.example.appspring.Entity.Voiture;

import java.util.List;

public interface VoitureService {
   // Voiture getVoitureByModel(String model);
    Voiture getVoitureByID(Long id);
    List<Voiture> getAllVoiture();
    void deleteVoiture(Long id);
    Voiture updateVoiture(Voiture nom);

    Voiture createVoiture(Voiture voiture);
}
