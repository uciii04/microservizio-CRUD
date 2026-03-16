package com.example.GestioneCatalogo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorie")
public class Categoria {
	
	@Id
    private String categoryId;

    private String code;
    private String nome;
    private String status;

    
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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

}
