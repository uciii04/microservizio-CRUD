package com.example.GestioneVendite.dto;

import java.math.BigDecimal;

public class PrezzoRispostaDTO {
	
	private String priceListId;
	private BigDecimal unitPrice;
    private BigDecimal prezzoScontato;
	
    
    public String getPriceListId() {
		return priceListId;
	}
	public void setPriceListId(String priceListId) {
		this.priceListId = priceListId;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getPrezzoScontato() {
		return prezzoScontato;
	}
	public void setPrezzoScontato(BigDecimal prezzoScontato) {
		this.prezzoScontato = prezzoScontato;
	}

}
