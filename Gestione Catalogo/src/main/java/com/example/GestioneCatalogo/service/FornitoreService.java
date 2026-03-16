package com.example.GestioneCatalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneCatalogo.model.Fornitore;
import com.example.GestioneCatalogo.repository.FornitoreRepository;

@Service
public class FornitoreService {
	
	@Autowired
    private FornitoreRepository fornitoreRepository;

    public Fornitore registraFornitore(Fornitore fornitore) {
        return fornitoreRepository.save(fornitore);
    }

    public List<Fornitore> recuperaTutti() {
        return fornitoreRepository.findAll();
    }

}
