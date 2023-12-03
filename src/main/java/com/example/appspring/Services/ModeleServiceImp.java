package com.example.appspring.Services;

import com.example.appspring.Entity.Modele;
import com.example.appspring.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleServiceImp implements ModeleService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public List<Modele> getAllModele() {
        return modelRepository.findAll();
    }

    @Override
    public Modele createModele(Modele modele) {
        return modelRepository.save(modele);
    }

    @Override
    public Modele getModeleByID(Long id) {
        return modelRepository.findById(id).get();
    }

    @Override
    public Modele updateModele(Modele modele) {
        return  modelRepository.saveAndFlush(modele);
    }

    @Override
    public void deleteModele(Long id) {
     modelRepository.deleteById(id);
    }
}
