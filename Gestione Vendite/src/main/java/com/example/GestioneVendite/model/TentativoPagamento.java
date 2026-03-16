package com.example.GestioneVendite.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tentativi_pagamento")
public class TentativoPagamento {

    @Id
    private String attemptId;

    private String paymentId;
    private Integer attemptNo;
    private LocalDateTime requestedAt;
    private String outcome;
    private String errorCode;
    private String errorMessage;
    

	public String getAttemptId() {
		return attemptId;
	}
	public void setAttemptId(String attemptId) {
		this.attemptId = attemptId;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	public Integer getAttemptNo() {
		return attemptNo;
	}
	public void setAttemptNo(Integer attemptNo) {
		this.attemptNo = attemptNo;
	}

	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}
	public void setRequestedAt(LocalDateTime requestedAt) {
		this.requestedAt = requestedAt;
	}

	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
    
}
