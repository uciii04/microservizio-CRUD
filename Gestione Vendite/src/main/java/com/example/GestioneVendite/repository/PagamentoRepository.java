package com.example.GestioneVendite.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.GestioneVendite.model.Pagamento;

@Repository
public interface PagamentoRepository extends MongoRepository<Pagamento, String> {

    List<Pagamento> findByOrderId(String orderId);
    
}
