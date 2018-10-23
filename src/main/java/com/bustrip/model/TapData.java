package com.bustrip.model;

import java.time.LocalDateTime;

public class TapData {
	private int Id;
	private LocalDateTime dateTimeUTC;
	private String tapType;
	private String stopId;
	private String companyId;
	private String busId;
	private String pan;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public LocalDateTime getDateTimeUTC() {
		return dateTimeUTC;
	}
	public void setDateTimeUTC(LocalDateTime p) {
		this.dateTimeUTC = p;
	}
	public String getTapType() {
		return tapType;
	}
	public void setTapType(String tapType) {
		this.tapType = tapType;
	}
	public String getStopId() {
		return stopId;
	}
	public void setStopId(String stopId) {
		this.stopId = stopId;
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
	
	
}
