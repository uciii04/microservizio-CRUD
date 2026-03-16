package com.example.GestioneCatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneCatalogo.model.Listino;
import com.example.GestioneCatalogo.model.Prezzo;
import com.example.GestioneCatalogo.repository.PrezzoRepository;
import com.example.GestioneCatalogo.service.ListinoService;
import com.example.GestioneCatalogo.service.PrezzoService;

@RestController
@RequestMapping("price-list")
public class ListinoController {
	
	@Autowired
	private ListinoService listinoService;
	
	@Autowired
	private PrezzoRepository prezzoRepository;
	
	@Autowired
	private PrezzoService prezzoService;
	
	// http://localhost:8080/price-list
	@PostMapping
	public Listino creaListino(@RequestBody Listino listino) {
		return listinoService.creaListino(listino);
	}
	
	// http://localhost:8080/price-list
	@GetMapping
	public List<Listino> getListini() {
		return listinoService.recuperaTutti();
	}
	
	// http://localhost:8080/price-list/{priceListId}/prices
	@PostMapping("/{priceListId}/prices")
	public Prezzo aggiungiPrezzo(@PathVariable String priceListId, @RequestBody Prezzo prezzo) {
	    prezzo.setPriceListId(priceListId);
	    return prezzoRepository.save(prezzo);
	}
	
	// http://localhost:8080/price-list/variants/{variantId}/best-price
	@GetMapping("/variants/{variantId}/best-price")
	public Prezzo getPrezzoVincente(@PathVariable String variantId) {
	    return prezzoService.calcolaPrezzoVincente(variantId);
	}

}
