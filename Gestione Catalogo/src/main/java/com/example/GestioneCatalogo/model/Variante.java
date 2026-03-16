package com.example.GestioneCatalogo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Variante {
	
	private String varianteId;
	private String productId;
	private String sku;
	private String nome;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private InformazioneFornitore infoFornitore;
    private int quantitaDisponibile;
    
    private List<Media> media = new ArrayList<>();
    private List<Barcode> barcodes = new ArrayList<>();
	
	
	private List<AttributoValore> attributi = new ArrayList<>();
	
	
	public String getVarianteId() {
		return varianteId;
	}
	public void setVariantId(String varianteId) {
		this.varianteId = varianteId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getNome() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public InformazioneFornitore getInfoFornitore() {
		return infoFornitore;
	}
	public void setInfoFornitore(InformazioneFornitore infoFornitore) {
		this.infoFornitore = infoFornitore;
	}
	
	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}
	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}
	
	public List<Media> getMedia() {
		return media;
	}
	public void setMedia(List<Media> media) {
		this.media = media;
	}
	
	public List<Barcode> getBarcodes() {
		return barcodes;
	}
	public void setBarcodes(List<Barcode> barcodes) {
		this.barcodes = barcodes;
	}
	
	public List<AttributoValore> getAttributi() {
		return attributi;
	}
	public void setAttributi(List<AttributoValore> attributi) {
		this.attributi = attributi;
	}

}
