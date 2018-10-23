package com.bustrip.model;

public class PriceTripData {
	private String fromStopId;
	private String toStopId;
	private Double chargeAmount;
	
	public String getFromStopId() {
		return fromStopId;
	}
	
	public void setFromStopId(String fromStopId) {
		this.fromStopId = fromStopId;
	}
	
	public String getToStopId() {
		return toStopId;
	}
	
	public void setToStopId(String toStopId) {
		this.toStopId = toStopId;
	}
	
	public Double getChargeAmount() {
		return chargeAmount;
	}
	
	public void setChargeAmount(Double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
}
