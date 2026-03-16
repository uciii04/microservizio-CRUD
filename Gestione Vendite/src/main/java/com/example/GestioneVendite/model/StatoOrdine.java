package com.example.GestioneVendite.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storico_stati_ordine")
public class StatoOrdine {

    @Id
    private String historyId;
	
    private String orderId;
    private String fromStatus;
    private String toStatus;
    private LocalDateTime changedAt;
    private String changedBy;
    private String note;


	public String getHistoryId() {
		return historyId;
	}
	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(String fromStatus) {
		this.fromStatus = fromStatus;
	}

	public String getToStatus() {
		return toStatus;
	}
	public void setToStatus(String toStatus) {
		this.toStatus = toStatus;
	}

	public LocalDateTime getChangedAt() {
		return changedAt;
	}
	public void setChangedAt(LocalDateTime changedAt) {
		this.changedAt = changedAt;
	}

	public String getChangedBy() {
		return changedBy;
	}
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

}
