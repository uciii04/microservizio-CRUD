package com.example.GestioneCatalogo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneCatalogo.model.AttributoValore;
import com.example.GestioneCatalogo.model.Barcode;
import com.example.GestioneCatalogo.model.InformazioneFornitore;
import com.example.GestioneCatalogo.model.Media;
import com.example.GestioneCatalogo.model.Prodotto;
import com.example.GestioneCatalogo.model.Variante;
import com.example.GestioneCatalogo.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	public Prodotto creaProdotto(Prodotto nuovoProdotto) {
		return prodottoRepository.save(nuovoProdotto);
	}
	
	public List<Prodotto> recuperaTuttiIProdotti(String status, boolean soloVisibiliCliente) {
        List<Prodotto> prodotti;
        if (status != null && !status.isEmpty()) {
            prodotti = prodottoRepository.findByStatus(status);
        } else {
            prodotti = prodottoRepository.findAll();
        }

        if (soloVisibiliCliente) {
            return prodotti.stream()
                    .filter(Prodotto::isVisibileCliente)
                    .toList();
        }
        
        return prodotti;
    }

    public Prodotto aggiungiVariante(String productId, Variante nuovaVariante) {
        Prodotto prodotto = prodottoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID: " + productId));

        nuovaVariante.setVariantId(UUID.randomUUID().toString());
        prodotto.getVarianti().add(nuovaVariante);

        return prodottoRepository.save(prodotto);
    }

    public Prodotto modificaVariante(String productId, String variantId, Variante datiAggiornati) {
        Prodotto prodotto = prodottoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato!"));

        for (Variante v : prodotto.getVarianti()) {
            if (v.getVarianteId().equals(variantId)) {
                v.setSku(datiAggiornati.getSku());
                v.setName(datiAggiornati.getNome());
                v.setStatus(datiAggiornati.getStatus());
                v.setQuantitaDisponibile(datiAggiornati.getQuantitaDisponibile());
            }
        }
        return prodottoRepository.save(prodotto);
    }
    
    public Prodotto aggiornaStockVariante(String idProdotto, String idVariante, int nuovaQuantita) {
        Prodotto prodotto = prodottoRepository.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        for (Variante v : prodotto.getVarianti()) {
            if (v.getVarianteId().equals(idVariante)) {
                v.setQuantitaDisponibile(nuovaQuantita);
                break;
            }
        }
        
        return prodottoRepository.save(prodotto);
    }
    
    public Prodotto aggiungiAttributoAVariante(String idProdotto, String idVariante, AttributoValore nuovoAttributo) {
        Prodotto prodotto = prodottoRepository.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con ID: " + idProdotto));

        for (Variante v : prodotto.getVarianti()) {
            if (v.getVarianteId().equals(idVariante)) {
                if (v.getAttributi() == null) {
                    v.setAttributi(new ArrayList<>());
                }
                v.getAttributi().add(nuovoAttributo);
                break;
            }
        }
        
        return prodottoRepository.save(prodotto);
    }
    
    public Prodotto associaFornitoreAVariante(String idProdotto, String idVariante, InformazioneFornitore info) {
        Prodotto prodotto = prodottoRepository.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        for (Variante v : prodotto.getVarianti()) {
            if (v.getVarianteId().equals(idVariante)) {
                v.setInfoFornitore(info);
                break;
            }
        }
        return prodottoRepository.save(prodotto);
    }
    
    public Prodotto aggiungiMediaAVariante(String idProdotto, String idVariante, Media nuovoMedia) {
        Prodotto prodotto = prodottoRepository.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        for (Variante v : prodotto.getVarianti()) {
            if (v.getVarianteId().equals(idVariante)) {
                if (v.getMedia() == null) v.setMedia(new ArrayList<>());
                v.getMedia().add(nuovoMedia);
                break;
            }
        }
        return prodottoRepository.save(prodotto);
    }
    
    public Prodotto aggiungiBarcodeAVariante(String idProdotto, String idVariante, Barcode nuovoBarcode) {
        Prodotto prodotto = prodottoRepository.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        for (Variante v : prodotto.getVarianti()) {
            if (v.getVarianteId().equals(idVariante)) {
                if (v.getBarcodes() == null) v.setBarcodes(new ArrayList<>());
                v.getBarcodes().add(nuovoBarcode);
                break;
            }
        }
        return prodottoRepository.save(prodotto);
    }
    
    public List<Prodotto> getProdottiPerCliente() {
        return prodottoRepository.findAll().stream()
                .filter(Prodotto::isVisibileCliente)
                .toList();
    }
    
    public void eliminaProdotto(String id) {
        if (!prodottoRepository.existsById(id)) {
            throw new RuntimeException("Impossibile eliminare: Prodotto non trovato");
        }
        prodottoRepository.deleteById(id);
    }

    public Prodotto eliminaVariante(String idProdotto, String idVariante) {
        Prodotto prodotto = prodottoRepository.findById(idProdotto)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));

        prodotto.getVarianti().removeIf(v -> v.getVarianteId().equals(idVariante));

        return prodottoRepository.save(prodotto);
    }

}
