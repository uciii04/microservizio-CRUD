package com.example.GestioneCatalogo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.Fornitore;

@Repository
public interface FornitoreRepository extends MongoRepository<Fornitore, String> {

}
