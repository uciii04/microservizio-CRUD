package com.example.GestioneCatalogo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.Attributo;

@Repository
public interface AttributoRepository extends MongoRepository <Attributo, String> {

}
