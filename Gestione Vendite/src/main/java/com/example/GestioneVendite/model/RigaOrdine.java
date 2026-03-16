package com.example.GestioneVendite.model;

import java.math.BigDecimal;

public class RigaOrdine {

    private String orderLineId;
    private String variantId;
    private String skuSnapshot;
    private String productNameSnapshot;
    private Integer quantity;
    private BigDecimal unitPriceGross;
    private BigDecimal lineAmount;
    private String appliedPriceListCodeSnapshot;
    private String appliedPriceRuleCodeSnapshot;

	
    public String getOrderLineId() {
		return orderLineId;
	}
	public void setOrderLineId(String orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getVariantId() {
		return variantId;
	}
	public void setVariantId(String string) {
		this.variantId = string;
	}

	public String getSkuSnapshot() {
		return skuSnapshot;
	}
	public void setSkuSnapshot(String skuSnapshot) {
		this.skuSnapshot = skuSnapshot;
	}

	public String getProductNameSnapshot() {
		return productNameSnapshot;
	}
	public void setProductNameSnapshot(String productNameSnapshot) {
		this.productNameSnapshot = productNameSnapshot;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPriceGross() {
		return unitPriceGross;
	}
	public void setUnitPriceGross(BigDecimal unitPriceGross) {
		this.unitPriceGross = unitPriceGross;
	}

	public BigDecimal getLineAmount() {
		return lineAmount;
	}
	public void setLineAmount(BigDecimal lineAmount) {
		this.lineAmount = lineAmount;
	}
	
	public String getAppliedPriceListCodeSnapshot() {
		return appliedPriceListCodeSnapshot;
	}
	public void setAppliedPriceListCodeSnapshot(String appliedPriceListCodeSnapshot) {
		this.appliedPriceListCodeSnapshot = appliedPriceListCodeSnapshot;
	}
	
	public String getAppliedPriceRuleCodeSnapshot() {
		return appliedPriceRuleCodeSnapshot;
	}
	public void setAppliedPriceRuleCodeSnapshot(String appliedPriceRuleCodeSnapshot) {
		this.appliedPriceRuleCodeSnapshot = appliedPriceRuleCodeSnapshot;
	}

}
