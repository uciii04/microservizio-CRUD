package com.example.GestioneVendite.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "ordini")
public class Ordine {

    @Id
    private String orderId;
	
	private String orderNumber;
    private String customerId;
    private String statusCurrent;
    private String currency;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private String createdBy;
    private String salesChannel;
    
    private List<RigaOrdine> righe = new ArrayList<>();

	
    public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getStatusCurrent() {
		return statusCurrent;
	}
	public void setStatusCurrent(String statusCurrent) {
		this.statusCurrent = statusCurrent;
	}

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getSalesChannel() {
		return salesChannel;
	}
	public void setSalesChannel(String salesChannel) {
		this.salesChannel = salesChannel;
	}
	
	public List<RigaOrdine> getRighe() {
	    return righe;
	}
	public void setRighe(List<RigaOrdine> righe) {
	    this.righe = righe;
	}

	public void addRiga(RigaOrdine riga) {
	    this.righe.add(riga);
	}

}
