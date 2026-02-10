package com.example.esercitazioneCRUD.esercitazioneCRUD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity          //Incapsulamento ed ereditarietà
public class AssetModel extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String nome;
	private String tipo;
	private String codiceSeriale;
	
    @Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getCodiceSeriale() {
		return codiceSeriale;
	}
	public void setCodiceSeriale(String codiceSeriale) {
		this.codiceSeriale = codiceSeriale;
	}

}
