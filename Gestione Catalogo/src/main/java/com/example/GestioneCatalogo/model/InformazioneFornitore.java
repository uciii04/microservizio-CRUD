package com.example.GestioneCatalogo.model;

public class InformazioneFornitore {
	
	private String supplierId;
    private Double prezzoCosto;
    private Integer leadTimeGiorni;
	
    
    public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	public Double getPrezzoCosto() {
		return prezzoCosto;
	}
	public void setPrezzoCosto(Double prezzoCosto) {
		this.prezzoCosto = prezzoCosto;
	}
	
	public Integer getLeadTimeGiorni() {
		return leadTimeGiorni;
	}
	public void setLeadTimeGiorni(Integer leadTimeGiorni) {
		this.leadTimeGiorni = leadTimeGiorni;
	}

}
