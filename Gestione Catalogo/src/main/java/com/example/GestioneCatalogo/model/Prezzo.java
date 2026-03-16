package com.example.GestioneCatalogo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prezzi")
public class Prezzo {
	
    @Id
    private String priceId;
    
    private String priceListId;
    private String varianteId;
    private Double unitPrice;
    private String valuta;
	
    
    public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	
	public String getPriceListId() {
		return priceListId;
	}
	public void setPriceListId(String priceListId) {
		this.priceListId = priceListId;
	}
	
	public String getVarianteId() {
		return varianteId;
	}
	public void setVarianteId(String varianteId) {
		this.varianteId = varianteId;
	}
	
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getValuta() {
		return valuta;
	}
	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

}
