package com.example.GestioneCatalogo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.Listino;

@Repository
public interface ListinoRepository extends MongoRepository<Listino, String> {

}
