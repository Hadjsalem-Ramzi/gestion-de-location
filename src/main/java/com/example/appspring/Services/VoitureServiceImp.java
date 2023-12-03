package com.example.appspring.Services;

import com.example.appspring.Entity.Voiture;
import com.example.appspring.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureServiceImp implements VoitureService{
    @Autowired
    private VoitureRepository voitureRepository;

    @Override
    public Voiture getVoitureByID(Long id) {

        return voitureRepository.findById(id).get();
    }


    @Override
    public List<Voiture> getAllVoiture() {

        return voitureRepository.findAll();
    }

    @Override
    public void deleteVoiture(Long id) {

        voitureRepository.deleteById(id);
    }

    @Override
    public Voiture updateVoiture(Voiture voiture)
    {
        return voitureRepository.saveAndFlush(voiture);
    }

    @Override
    public Voiture createVoiture(Voiture voiture) {

        return voitureRepository.save(voiture);
    }
}
