package com.vintrace.breakdown.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Component {
	
	private double percentage; // percentage
	private String year;
	private String variety;
	private String region;
	
	public Component() {
		
	}
	public Component(double percentage, String year, String variety, String region) {
		this.percentage = percentage;
		this.year = year;
		this.variety = variety;
		this.region = region;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	

}
