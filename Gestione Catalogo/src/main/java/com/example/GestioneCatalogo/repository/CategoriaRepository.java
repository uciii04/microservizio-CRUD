package com.example.GestioneCatalogo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {

}
