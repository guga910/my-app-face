package com.ajudaqui.myappface.model;

import java.math.BigDecimal;

public class Trip {
	
	private Long id;
	private Long userNote;
	private String district;
	private Double toUsers;
	private Double toDestination;
	private BigDecimal value;
	private Integer timeToUsers;
	private Integer timeToDestination;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getToUsers() {
		return toUsers;
	}
	public void setToUsers(Double toUsers) {
		this.toUsers = toUsers;
	}
	public Double getToDestination() {
		return toDestination;
	}
	public void setToDestination(Double toDestination) {
		this.toDestination = toDestination;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Integer getTimeToUsers() {
		return timeToUsers;
	}
	public void setTimeToUsers(Integer timeToUsers) {
		this.timeToUsers = timeToUsers;
	}
	public Integer getTimeToDestination() {
		return timeToDestination;
	}
	public void setTimeToDestination(Integer timeToDestination) {
		this.timeToDestination = timeToDestination;
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
	
	
	
	
	
//	starting km
//	final km
//	value
//	time to start
//	race time

}
