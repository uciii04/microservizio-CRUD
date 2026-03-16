package com.example.GestioneVendite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.GestioneVendite.dto.CarrelloDTO;
import com.example.GestioneVendite.dto.PrezzoRispostaDTO;
import com.example.GestioneVendite.model.Documento;
import com.example.GestioneVendite.model.Ordine;
import com.example.GestioneVendite.model.Pagamento;
import com.example.GestioneVendite.model.RigaDocumento;
import com.example.GestioneVendite.model.RigaOrdine;
import com.example.GestioneVendite.model.StatoOrdine;
import com.example.GestioneVendite.model.TentativoPagamento;
import com.example.GestioneVendite.repository.DocumentoRepository;
import com.example.GestioneVendite.repository.OrdineRepository;
import com.example.GestioneVendite.repository.PagamentoRepository;
import com.example.GestioneVendite.repository.StatoOrdineRepository;
import com.example.GestioneVendite.repository.TentativoPagamentoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class VenditeService {

    @Autowired
    private OrdineRepository ordineRepository;
    
    @Autowired
    private StatoOrdineRepository statoOrdineRepository;
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private TentativoPagamentoRepository tentativoRepository;
    
    @Autowired
    private DocumentoRepository documentoRepository;

        @Transactional
        public Ordine creaNuovoOrdine(String customerId, List<CarrelloDTO> items) {
            Ordine ordine = new Ordine();
            ordine.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8));
            ordine.setCustomerId(customerId);
            ordine.setStatusCurrent("CREATO");
            ordine.setCreatedAt(LocalDateTime.now());
            ordine.setCurrency("EUR");
            ordine.setCreatedBy("SISTEMA_WEB");

            RestTemplate restTemplate = new RestTemplate();
            BigDecimal totaleOrdine = BigDecimal.ZERO;

            for (CarrelloDTO item : items) {
                String url = "http://localhost:8080/prezzi/vincente/" + item.getVarianteId();
                
                PrezzoRispostaDTO risposta = restTemplate.getForObject(url, PrezzoRispostaDTO.class);

                if (risposta == null || risposta.getUnitPrice() == null) {
                    throw new RuntimeException("Impossibile procedere: Prezzo non trovato o non valido per la variante: " + item.getVarianteId());
                }

                RigaOrdine riga = new RigaOrdine();
                riga.setVariantId(item.getVarianteId());
                riga.setSkuSnapshot(item.getSku());
                riga.setProductNameSnapshot(item.getProductName());
                riga.setQuantity(item.getQuantita());
                
                BigDecimal prezzoUnitario = risposta.getUnitPrice();
                riga.setUnitPriceGross(prezzoUnitario);
                riga.setAppliedPriceListCodeSnapshot(risposta.getPriceListId());

                BigDecimal totaleRiga = prezzoUnitario.multiply(new BigDecimal(item.getQuantita()));
                riga.setLineAmount(totaleRiga);
                
                ordine.addRiga(riga);
                
                totaleOrdine = totaleOrdine.add(totaleRiga);
            }

            ordine.setTotalAmount(totaleOrdine);

            return ordineRepository.save(ordine);
        }
    
    @Transactional
    public Ordine cambiaStato(String orderId, String nuovoStato, String operatore, String note) {
        Ordine ordine = ordineRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));

        StatoOrdine storico = new StatoOrdine();
        storico.setOrderId(ordine.getOrderId());
        storico.setFromStatus(ordine.getStatusCurrent());
        storico.setToStatus(nuovoStato);
        storico.setChangedAt(LocalDateTime.now());
        storico.setChangedBy(operatore);
        storico.setNote(note);

        ordine.setStatusCurrent(nuovoStato);
        
        statoOrdineRepository.save(storico);
        
        return ordineRepository.save(ordine);
    }
    
    public List<StatoOrdine> getTimelineOrdine(String orderId) {
        ordineRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));
        return statoOrdineRepository.findByOrderIdOrderByChangedAtAsc(orderId);
    }
    
    @Transactional
    public Pagamento inizializzaPagamento(String orderId, String provider, String metodo) {
        Ordine ordine = ordineRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));

        Pagamento pagamento = new Pagamento();
        pagamento.setOrderId(ordine.getOrderId());
        pagamento.setAmount(ordine.getTotalAmount()); 
        pagamento.setProvider(provider);
        pagamento.setPaymentMethod(metodo);
        pagamento.setStatusCurrent("INIZIATO");
        pagamento.setCreatedAt(LocalDateTime.now());

        return pagamentoRepository.save(pagamento);
    }

    @Transactional
    public TentativoPagamento registraTentativo(String paymentId, String esito, String codiceErrore, String messaggio) {
        Pagamento pagamento = pagamentoRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Pagamento non trovato"));

        TentativoPagamento tentativo = new TentativoPagamento();
        tentativo.setPaymentId(pagamento.getPaymentId());
        tentativo.setRequestedAt(LocalDateTime.now());
        tentativo.setOutcome(esito);
        tentativo.setErrorCode(codiceErrore);
        tentativo.setErrorMessage(messaggio);
        
        if ("SUCCESS".equals(esito)) {
            pagamento.setStatusCurrent("PAGATO");
            cambiaStato(pagamento.getOrderId(), "PAGATO", "SISTEMA_PAGAMENTI", "Pagamento confermato");
        } else {
            pagamento.setStatusCurrent("FALLITO");
        }

        pagamentoRepository.save(pagamento);
        return tentativoRepository.save(tentativo);
    }
    
    @Transactional
    public Documento generaFattura(String orderId) {
        Ordine ordine = ordineRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Ordine non trovato"));

        Documento fattura = new Documento();
        fattura.setOrderId(ordine.getOrderId());
        fattura.setDocumentType("FATTURA");
        fattura.setDocumentNumber("FT-" + LocalDateTime.now().getYear() + "-" + ordine.getOrderId());
        fattura.setIssueDate(LocalDate.now());
        fattura.setStatus("ISSUED");
        fattura.setTotalAmount(ordine.getTotalAmount()); 

        for (RigaOrdine rigaOrd : ordine.getRighe()) {
            RigaDocumento rigaDoc = new RigaDocumento();
            rigaDoc.setDescriptionSnapshot(rigaOrd.getProductNameSnapshot());
            rigaDoc.setQuantity(rigaOrd.getQuantity());
            rigaDoc.setUnitPrice(rigaOrd.getUnitPriceGross());
            rigaDoc.setLineAmount(rigaOrd.getLineAmount());
            
            fattura.getRighe().add(rigaDoc);
        }

        return documentoRepository.save(fattura);
    }
}