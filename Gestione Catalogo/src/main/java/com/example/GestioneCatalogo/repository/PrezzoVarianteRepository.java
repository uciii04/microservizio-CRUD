package com.example.GestioneCatalogo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.PrezzoVariante;

@Repository
public interface PrezzoVarianteRepository extends MongoRepository<PrezzoVariante, String>{

}
