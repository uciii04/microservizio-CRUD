package com.example.GestioneCatalogo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "listini")
public class Listino {
    @Id
    private String id;
    private String nome;
    
    @CreatedDate
    private LocalDateTime dataInizio;
    
    @LastModifiedDate
    private LocalDateTime dataFine;
    
    private Integer priorita;
    private String status;
	
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public LocalDateTime getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	public LocalDateTime getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}
	
	public Integer getPriorita() {
		return priorita;
	}
	public void setPriorita(Integer priorita) {
		this.priorita = priorita;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
