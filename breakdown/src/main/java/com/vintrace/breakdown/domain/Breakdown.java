package com.vintrace.breakdown.domain;

public class Breakdown implements Comparable<Breakdown>{
	
	private Integer percentage; // total percentage
	private String key; // breakdown type
	
	
	public Breakdown() {

	}
	public Breakdown(Integer percentage, String key) {
		this.percentage = percentage;
		this.key = key;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@Override
	public int compareTo(Breakdown b) {
		return (int)(b.getPercentage() - this.percentage);
	}
	
	

}
