package com.example.GestioneVendite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestioneVendite.dto.CarrelloDTO;
import com.example.GestioneVendite.model.Documento;
import com.example.GestioneVendite.model.Ordine;
import com.example.GestioneVendite.model.Pagamento;
import com.example.GestioneVendite.model.StatoOrdine;
import com.example.GestioneVendite.model.TentativoPagamento;
import com.example.GestioneVendite.repository.DocumentoRepository;
import com.example.GestioneVendite.service.VenditeService;

@RestController
@RequestMapping("vendite/ordini")
public class VenditeController {
	
	@Autowired
	private VenditeService venditeService;
	
	@Autowired
    private DocumentoRepository documentoRepository;
	
	// http://localhost:8081/vendite/ordini/{customerId}
	@PostMapping("/{customerId}")
    public Ordine creaOrdine(@PathVariable String customerId, @RequestBody List<CarrelloDTO> items) {
        return venditeService.creaNuovoOrdine(customerId, items);
    }
	
	// http://localhost:8081/vendite/ordini/{orderId}/stato
	@PostMapping("/{orderId}/stato")
	public Ordine cambiaStato(
	        @PathVariable String orderId, 
	        @RequestParam String nuovoStato,
	        @RequestParam String operatore) {
	    return venditeService.cambiaStato(orderId, nuovoStato, operatore, "Cambio stato manuale");
	}

	// http://localhost:8081/vendite/ordini/{orderId}/timeline
	@GetMapping("/{orderId}/timeline")
	public List<StatoOrdine> getTimeline(@PathVariable String orderId) {
	    return venditeService.getTimelineOrdine(orderId);
	}
	
	// http://localhost:8081/vendite/ordini/pagamenti/inizializza
	@PostMapping("/pagamenti/inizializza")
	public Pagamento inizializza(@RequestParam String orderId, @RequestParam String provider) {
	    return venditeService.inizializzaPagamento(orderId, provider, "CARTA_CREDITO");
	}

	// http://localhost:8081/vendite/ordini/pagamenti/{paymentId}/tentativo
	@PostMapping("/pagamenti/{paymentId}/tentativo")
	public TentativoPagamento tentativo(
	        @PathVariable String paymentId,
	        @RequestParam String esito,
	        @RequestParam(required = false) String codiceErrore,
	        @RequestParam(required = false) String messaggio) {
	    return venditeService.registraTentativo(paymentId, esito, codiceErrore, messaggio);
	}
	
	// http://localhost:8081/vendite/ordini/{orderId}/fattura
	@PostMapping("/{orderId}/fattura")
	public Documento generaFattura(@PathVariable String orderId) {
	    return venditeService.generaFattura(orderId);
	}
	
	// http://localhost:8081/vendite/ordini/{orderId}/documenti
	@GetMapping("/{orderId}/documenti")
	public List<Documento> getDocumenti(@PathVariable String orderId) {
	    return documentoRepository.findByOrderId(orderId);
	}

}