package com.example.GestioneCatalogo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "prezzi_varianti")
public class PrezzoVariante {
    @Id
    private String id;
    
    @Field("variant_id")
    private String varianteId;
    
    @Field("listino_id")
    private String listinoId;
    
    private Double prezzo;
    private String valuta;
	
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getVarianteId() {
		return varianteId;
	}
	public void setVariantId(String varianteId) {
		this.varianteId = varianteId;
	}
	
	public String getListinoId() {
		return listinoId;
	}
	public void setListinoId(String listinoId) {
		this.listinoId = listinoId;
	}
	
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getValuta() {
		return valuta;
	}
	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

}
