package com.example.GestioneVendite.dto;

import java.math.BigDecimal;

public class CarrelloDTO {
	
	private String varianteId;
	private String sku;
	private String productName;
	private Integer quantita;
	private BigDecimal priceAtPurchase;
	private String appliedPriceListCode;
    private String appliedPriceRuleCode;
	
	
	public String getVarianteId() {
		return varianteId;
	}
	public void setVarianteId(String varianteId) {
		this.varianteId = varianteId;
	}
	
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantity(Integer quantita) {
		this.quantita = quantita;
	}
	
	public BigDecimal getPriceAtPurchase() {
		return priceAtPurchase;
	}
	public void setPriceAtPurchase(BigDecimal priceAtPurchase) {
		this.priceAtPurchase = priceAtPurchase;
	}
	
	public String getAppliedPriceListCode() {
		return appliedPriceListCode;
	}
	public void setAppliedPriceListCode(String appliedPriceListCode) {
		this.appliedPriceListCode = appliedPriceListCode;
	}
	
	public String getAppliedPriceRuleCode() {
		return appliedPriceRuleCode;
	}
	public void setAppliedPriceRuleCode(String appliedPriceRuleCode) {
		this.appliedPriceRuleCode = appliedPriceRuleCode;
	}

}
