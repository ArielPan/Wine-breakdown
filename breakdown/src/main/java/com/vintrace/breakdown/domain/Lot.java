package com.vintrace.breakdown.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Lot {
	
	private String lotCode;
	private List<Component> components;
	
	public Lot() {

	}
	public Lot(String lotCode, List<Component> components) {
		this.lotCode = lotCode;
		this.components = components;
	}
	public String getLotCode() {
		return lotCode;
	}
	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}
	public List<Component> getComponents() {
		return components;
	}
	public void setComponents(List<Component> components) {
		this.components = components;
	}
	
	

}
