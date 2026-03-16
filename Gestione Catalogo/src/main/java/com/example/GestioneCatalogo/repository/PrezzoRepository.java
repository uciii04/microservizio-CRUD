package com.example.GestioneCatalogo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.Prezzo;

@Repository
public interface PrezzoRepository extends MongoRepository<Prezzo, String> {
	
    List<Prezzo> findByPriceListId(String priceListId);
    
    List<Prezzo> findByVariantId(String variantId);

}
