package com.example.GestioneCatalogo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotBlank;

@Document(collection = "prodotti")
public class Prodotto {
	
	@Id
    private String productId;
	
	@Field("product_code")
	@NotBlank
    private String productCode;
	
	@NotBlank
    private String nome;
	
    private String descrizione;
    private String status;
    
    @CreatedDate
    @Field("created_at")
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    @Field("updated_at")
    private LocalDateTime updatedAt;
    
    @Field("visibile_cliente")
    private boolean visibileCliente = true;
    
    private List<Variante> varianti = new ArrayList<>();

	
    public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescription(String descrizione) {
		this.descrizione = descrizione;
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

	public boolean isVisibileCliente() {
		return visibileCliente;
	}
	public void setVisibileCliente(boolean visibileCliente) {
		this.visibileCliente = visibileCliente;
	}
	
	public List<Variante> getVarianti() {
		return varianti;
	}
	public void setVarianti(List<Variante> varianti) {
		this.varianti = varianti;
	}

}
