package com.example.GestioneVendite.model;

import java.math.BigDecimal;

public class RigaDocumento {

    private String documentLineId;
    private String descriptionSnapshot;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineAmount;
	
    
    public String getDocumentLineId() {
		return documentLineId;
	}
	public void setDocumentLineId(String documentLineId) {
		this.documentLineId = documentLineId;
	}
	
	public String getDescriptionSnapshot() {
		return descriptionSnapshot;
	}
	public void setDescriptionSnapshot(String descriptionSnapshot) {
		this.descriptionSnapshot = descriptionSnapshot;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getLineAmount() {
		return lineAmount;
	}
	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}
	
}
