package com.example.GestioneCatalogo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GestioneCatalogo.model.Listino;
import com.example.GestioneCatalogo.model.Prezzo;
import com.example.GestioneCatalogo.repository.ListinoRepository;
import com.example.GestioneCatalogo.repository.PrezzoRepository;

@Service
public class PrezzoService {
	
	@Autowired
	private ListinoRepository listinoRepository;
	
	@Autowired
    private PrezzoRepository prezzoRepository;

	public Prezzo calcolaPrezzoVincente(String variantId) {
	    List<Prezzo> listaPrezzi = prezzoRepository.findByVariantId(variantId);
	    
	    Prezzo migliorPrezzo = null;
	    int prioritaPiuAlta = -1;

	    for (Prezzo p : listaPrezzi) {
	        Optional<Listino> listinoOpt = listinoRepository.findById(p.getPriceListId());

	        if (listinoOpt.isPresent()) {
	            Listino l = listinoOpt.get();
	            LocalDateTime oggi = LocalDateTime.now();

	            boolean statoOk = "ACTIVE".equals(l.getStatus());
	            boolean dataInizioOk = oggi.isAfter(l.getDataInizio());
	            boolean dataFineOk = oggi.isBefore(l.getDataFine());

	            System.out.println("Esamino Listino: " + l.getNome());
	            System.out.println(" -> Stato ACTIVE? " + statoOk + " (Attuale: " + l.getStatus() + ")");
	            System.out.println(" -> Data Inizio OK? " + dataInizioOk + " (Inizio: " + l.getDataInizio() + ")");
	            System.out.println(" -> Data Fine OK? " + dataFineOk + " (Fine: " + l.getDataFine() + ")");

	            if (statoOk) { 
	                if (l.getPriorita() > prioritaPiuAlta) {
	                    prioritaPiuAlta = l.getPriorita();
	                    migliorPrezzo = p;
	                }
	            }
	        } else {
	            System.out.println(" -> Listino ID " + p.getPriceListId() + " NON TROVATO nel DB!");
	        }
	    }
	    return migliorPrezzo;
	}
}