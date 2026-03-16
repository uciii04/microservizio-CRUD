package com.example.GestioneCatalogo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneCatalogo.model.Prodotto;

@Repository
public interface ProdottoRepository extends MongoRepository<Prodotto, String> {
	
	List<Prodotto> findByStatus(String status);
	
	Optional <Prodotto> findByProductId(String productId);
}
