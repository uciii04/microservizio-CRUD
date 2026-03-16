package com.example.GestioneVendite.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneVendite.model.StatoOrdine;


@Repository
public interface StatoOrdineRepository extends MongoRepository<StatoOrdine, String> {

    List<StatoOrdine> findByOrderIdOrderByChangedAtAsc(String orderId);
    
}
