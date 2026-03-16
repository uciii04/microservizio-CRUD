package com.example.GestioneVendite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneVendite.model.Ordine;

@Repository
public interface OrdineRepository extends MongoRepository<Ordine, String> {
	
    Optional<Ordine> findByOrderNumber(String orderNumber);
    
    List<Ordine> findByCustomerId(String customerId);

}
