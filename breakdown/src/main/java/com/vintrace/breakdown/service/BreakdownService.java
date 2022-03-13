package com.vintrace.breakdown.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vintrace.breakdown.domain.Breakdown;
import com.vintrace.breakdown.domain.Component;
import com.vintrace.breakdown.domain.Lot;
import com.vintrace.breakdown.domain.Response;

/**
 * @author ArielPan
 *
 */
@Service
public class BreakdownService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Response getBreakDownByYear(Lot lot) {
		String type = "year";
		List<Breakdown> breakdownList = processBreakdown(lot, type);
		Response res = new Response();
		res.setBreakdown(breakdownList);
		res.setBreakDowntype(type);
		return res;
		
	}
	
	public Response getBreakDownByVariety(Lot lot) {
		String type = "variety";
		List<Breakdown> breakdownList = processBreakdown(lot, type);
		Response res = new Response();
		res.setBreakdown(breakdownList);
		res.setBreakDowntype(type);
		return res;
		
	}
	
	public Response getBreakDownByRegion(Lot lot) {
		String type = "region";
		List<Breakdown> breakdownList = processBreakdown(lot, type);
		Response res = new Response();
		res.setBreakdown(breakdownList);
		res.setBreakDowntype(type);
		return res;
		
	}
	
	public Response getBreakDownByYearAndVariety(Lot lot) {
		String type = "year-variety";
		List<Breakdown> breakdownList = processBreakdown(lot, type);
		Response res = new Response();
		res.setBreakdown(breakdownList);
		res.setBreakDowntype(type);
		return res;
		
	}
	
	
	
	/**
	 * @param lotCode
	 * @return Lot object maps to the JSON file
	 * @throws IOException throw exception if the JSON file does not exist
	 */
	public Lot readJSONFile(String lotCode) throws IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		Lot lot = new Lot();
		try {
			InputStream file = new ClassPathResource("asset/" + lotCode + ".json").getInputStream();
			lot = objectMapper.readValue(file, Lot.class);
		} catch (IOException e) {
			logger.error("File does not exsit");
			throw new IOException("File does not exsit, please check the Lot Code and try again");
		}
		return lot;
	}
	
	
	/**
	 * @param lot
	 * @param type
	 * @return return a breakdown of the total percentage grouped by different breakdown type
	 */
	private List<Breakdown> processBreakdown(Lot lot, String type) {
		List<Component> components = lot.getComponents();
		List<Breakdown> breakdownList = new ArrayList<Breakdown>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		switch (type) {
		case "year":
			for(Component c: components) {
				map.put(c.getYear(), map.getOrDefault(c.getYear(), 0) + (int)Math.round(c.getPercentage()));
			}
			break;
		case "variety":
			for(Component c: components) {
				map.put(c.getVariety(), map.getOrDefault(c.getVariety(), 0) + (int)Math.round(c.getPercentage()));
			}
			break;
		case "region":
			for(Component c: components) {
				map.put(c.getRegion(), map.getOrDefault(c.getRegion(), 0) + (int)Math.round(c.getPercentage()));
			}
			break;
		case "year-variety":
			for(Component c: components) {
				map.put(c.getYear() + " - " + c.getVariety(), map.getOrDefault(c.getYear() + " - " + c.getVariety(), 0) + (int)Math.round(c.getPercentage()));
			}
			break;
		default:
			break;
		}
		for (String key : map.keySet()) {
			Breakdown bd = new Breakdown();
			bd.setKey(key);
			bd.setPercentage(map.get(key));
			breakdownList.add(bd);
		}
		Collections.sort(breakdownList);
		
		return breakdownList;
		
	}

}
