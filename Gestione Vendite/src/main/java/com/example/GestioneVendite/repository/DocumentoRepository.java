package com.example.GestioneVendite.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneVendite.model.Documento;

@Repository
public interface DocumentoRepository extends MongoRepository<Documento, String> {
	
	List<Documento> findByOrderId(String orderId);
    
}
