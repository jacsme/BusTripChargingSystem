package com.bustrip.model;

import java.time.LocalDateTime;

public class TripTransactionReport {
	public LocalDateTime started;
	public LocalDateTime finished;
	public String durationSecs;
	public String fromStopId;
	public String toStopId;
	public Double chargeAmount;
	public String companyId;
	public String busId;
	public String pan;
	public String status;
	
	public LocalDateTime getStarted() {
		return started;
	}
	
	public void setStarted(LocalDateTime started) {
		this.started = started;
	}
	
	public LocalDateTime getFinished() {
		return finished;
	}
	
	public void setFinished(LocalDateTime finished) {
		this.finished = finished;
	}
	
	public String getDurationSecs() {
		return durationSecs;
	}
	
	public void setDurationSecs(String durationSecs) {
		this.durationSecs = durationSecs;
	}
	
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
	
	public String getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	public String getBusId() {
		return busId;
	}
	
	public void setBusId(String busId) {
		this.busId = busId;
	}
	
	public String getPan() {
		return pan;
	}
	
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
