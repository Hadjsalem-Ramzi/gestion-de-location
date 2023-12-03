package com.example.appspring.repository;

import com.example.appspring.Entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long>,VoitureRepositoryCustom{
}
