package com.ajudaqui.myappface.service.response;

import java.math.BigDecimal;

public class SummaryTrip {
	// real \ km, velocidade media, nota do usuario, bairro
	private BigDecimal pricePerKm;
	private Double averageSpeed;
	private Long userNote;
	private String district;
	
	public BigDecimal getPricePerKm() {
		return pricePerKm;
	}
	public void setPricePerKm(BigDecimal pricePerKm) {
		this.pricePerKm = pricePerKm;
	}
	public Double getAverageSpeed() {
		return averageSpeed;
	}
	public void setAverageSpeed(Double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	public Long getUserNote() {
		return userNote;
	}
	public void setUserNote(Long userNote) {
		this.userNote = userNote;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	

}
