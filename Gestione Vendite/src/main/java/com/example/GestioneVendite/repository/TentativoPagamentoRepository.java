package com.example.GestioneVendite.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneVendite.model.TentativoPagamento;

@Repository
public interface TentativoPagamentoRepository extends MongoRepository<TentativoPagamento, String> {
	
    List<TentativoPagamento> findByPaymentIdOrderByRequestedAtDesc(String paymentId);

}
