package com.vintrace.breakdown.domain;

import java.util.List;

public class Response {
	
	private String breakDowntype;
	private List<Breakdown> breakdownList;
	
	
	public Response() {

	}
	public Response(String breakDowntype, List<Breakdown> breakdownList) {
		this.breakDowntype = breakDowntype;
		this.breakdownList = breakdownList;
	}
	public String getBreakDowntype() {
		return breakDowntype;
	}
	public void setBreakDowntype(String breakDowntype) {
		this.breakDowntype = breakDowntype;
	}
	public List<Breakdown> getBreakdown() {
		return breakdownList;
	}
	public void setBreakdown(List<Breakdown> breakdownList) {
		this.breakdownList = breakdownList;
	}
	
	

}
