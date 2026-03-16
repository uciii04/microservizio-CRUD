package com.example.GestioneCatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneCatalogo.model.Fornitore;
import com.example.GestioneCatalogo.service.FornitoreService;

@RestController
@RequestMapping("suppliers")
public class FornitoreController {
	
	@Autowired
    private FornitoreService fornitoreService;

	// http://localhost:8080/suppliers
    @PostMapping
    public Fornitore registraFornitore(@RequestBody Fornitore fornitore) {
        return fornitoreService.registraFornitore(fornitore);
    }

    // http://localhost:8080/suppliers
    @GetMapping
    public List<Fornitore> getFornitori() {
        return fornitoreService.recuperaTutti();
    }

}
