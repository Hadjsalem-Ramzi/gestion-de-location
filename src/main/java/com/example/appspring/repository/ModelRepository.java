package com.example.appspring.repository;

import com.example.appspring.Entity.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Modele,Long> {
}
