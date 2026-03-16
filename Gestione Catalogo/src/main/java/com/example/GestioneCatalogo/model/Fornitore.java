package com.example.GestioneCatalogo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "fornitori")
public class Fornitore {
	
	@Id
    private String id;
    
    private String nome;
    private String codiceFornitore;
    private String emailContatto;

    @Field("tempo_consegna")
    private Integer tempoConsegna;

    @Field("lotto_minimo")
    private Integer lottoMinimo;

    
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

	public String getCodiceFornitore() {
		return codiceFornitore;
	}
	public void setCodiceFornitore(String codiceFornitore) {
		this.codiceFornitore = codiceFornitore;
	}
	
	public String getEmailContatto() {
		return emailContatto;
	}
	public void setEmailContatto(String emailContatto) {
		this.emailContatto = emailContatto;
	}
	
	public Integer getTempoConsegna() {
		return tempoConsegna;
	}
	public void setTempoConsegna(Integer tempoConsegna) {
		this.tempoConsegna = tempoConsegna;
	}

	public Integer getLottoMinimo() {
		return lottoMinimo;
	}
	public void setLottoMinimo(Integer lottoMinimo) {
		this.lottoMinimo = lottoMinimo;
	}

}
