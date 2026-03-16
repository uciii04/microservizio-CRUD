package com.example.GestioneCatalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneCatalogo.model.AttributoValore;
import com.example.GestioneCatalogo.model.Barcode;
import com.example.GestioneCatalogo.model.InformazioneFornitore;
import com.example.GestioneCatalogo.model.Media;
import com.example.GestioneCatalogo.model.Prodotto;
import com.example.GestioneCatalogo.model.Variante;
import com.example.GestioneCatalogo.service.ProdottoService;

@RestController
@RequestMapping("products")
public class ProdottoController {
	
	@Autowired
    private ProdottoService prodottoService;
	
	// http://localhost:8080/products
	@PostMapping
    public Prodotto creaProdotto(@RequestBody Prodotto prodotto) {
        return prodottoService.creaProdotto(prodotto);
    }
	
	// http://localhost:8080/products
	@GetMapping
    public List<Prodotto> getProdotti(
    		@RequestParam(required = false) String status,
    		@RequestParam(defaultValue = "false") boolean soloVisibili) { 
        
		if (soloVisibili) {
			return prodottoService.getProdottiPerCliente();
		}
        return prodottoService.recuperaTuttiIProdotti(status, soloVisibili);
    }
	
	// http://localhost:8080/products/{id}/variants
	@PostMapping("/{id}/variants") 
	public Prodotto aggiungiVariante(@PathVariable String id, @RequestBody Variante variante) {
        return prodottoService.aggiungiVariante(id, variante);
    }
	
	// http://localhost:8080/products/{id}/variants/{variantId}/stock
		@PutMapping("/{id}/variants/{variantId}/stock")
		public Prodotto aggiornaStock(
				@PathVariable String id, 
				@PathVariable String variantId, 
				@RequestParam int quantita) {
			return prodottoService.aggiornaStockVariante(id, variantId, quantita);
		}
	
	// http://localhost:8080/products/{id}/variants/{variantId}
	@PutMapping("/{id}/variants/{variantId}")
	public Prodotto modificaVariante(@PathVariable String id, @PathVariable String variantId, @RequestBody Variante variante) {
        return prodottoService.modificaVariante(id, variantId, variante);
    }
	
	// http://localhost:8080/products/{productId}/variants/{variantId}/attributes
	@PostMapping("/{productId}/variants/{variantId}/attributes")
	public Prodotto aggiungiAttributoAVariante(
	        @PathVariable String productId, 
	        @PathVariable String variantId, 
	        @RequestBody AttributoValore attributoValore) {
	    
	    return prodottoService.aggiungiAttributoAVariante(productId, variantId, attributoValore);
	}
	
	// http://localhost:8080/products/{productId}/variants/{variantId}/supplier-info
		@PostMapping("/{productId}/variants/{variantId}/supplier-info")
		public Prodotto associaFornitore(
		        @PathVariable String productId, 
		        @PathVariable String variantId, 
		        @RequestBody InformazioneFornitore info) {
		    
		    return prodottoService.associaFornitoreAVariante(productId, variantId, info);
		}
		
	// http://localhost:8080/products/{productId}/variants/{variantId}/media
		@PostMapping("/{productId}/variants/{variantId}/media")
		public Prodotto aggiungiMedia(@PathVariable String productId, @PathVariable String variantId, @RequestBody Media media) {
		    return prodottoService.aggiungiMediaAVariante(productId, variantId, media);
		}
		
	// http://localhost:8080/products/{productId}/variants/{variantId}/barcodes
		@PostMapping("/{productId}/variants/{variantId}/barcodes")
		public Prodotto aggiungiBarcode(@PathVariable String productId, @PathVariable String variantId, @RequestBody Barcode barcode) {
		    return prodottoService.aggiungiBarcodeAVariante(productId, variantId, barcode);
		}
		
	// http://localhost:8080/products/{id}
		@DeleteMapping("/{id}")
		public void eliminaProdotto(@PathVariable String id) {
		    prodottoService.eliminaProdotto(id);
		}

	// http://localhost:8080/products/{id}/variants/{variantId}
		@DeleteMapping("/{id}/variants/{variantId}")
		public Prodotto eliminaVariante(@PathVariable String id, @PathVariable String variantId) {
		    return prodottoService.eliminaVariante(id, variantId);
		}

}
