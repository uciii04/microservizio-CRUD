package com.example.esercitazioneCRUD.esercitazioneCRUD.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AssetDTO {
	
	private Long id;
	
	@NotBlank(message = "Il campo nome è obbligatorio!")
    private String nome;
    
    @NotBlank(message = "Il campo tipo è obbligatorio!")
    private String tipo;
    
    @Size(min = 5, message = "Il codice seriale deve avere almeno 5 caratteri!")
    private String codiceSeriale;

    
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
