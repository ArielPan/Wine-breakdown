package com.vintrace.breakdown.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vintrace.breakdown.domain.Lot;
import com.vintrace.breakdown.domain.Response;
import com.vintrace.breakdown.service.BreakdownService;

@RestController
@RequestMapping(path = "/api/breakdown")
public class BreakdownController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BreakdownService breakdownService;
	
	@RequestMapping(value = "/year/{lotCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getBreakdownByYear (@PathVariable String lotCode) {
		logger.info("Get a breakdown of the TOTAL percentage grouped by year for " + lotCode);
		
		Lot lot = new Lot();
		try {
			lot = breakdownService.readJSONFile(lotCode); //read the json file based on lotCode and mapping to domain object
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Response>(breakdownService.getBreakDownByYear(lot), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/variety/{lotCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getBreakdownByVariety (@PathVariable String lotCode) {
		logger.info("Get a breakdown of the TOTAL percentage grouped by variety for " + lotCode);
		Lot lot = new Lot();
		try {
			lot = breakdownService.readJSONFile(lotCode);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(breakdownService.getBreakDownByVariety(lot), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/region/{lotCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getBreakdownByRegion (@PathVariable String lotCode) {
		logger.info("Get a breakdown of the TOTAL percentage grouped by region for " + lotCode);
		Lot lot = new Lot();
		try {
			lot = breakdownService.readJSONFile(lotCode);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(breakdownService.getBreakDownByRegion(lot), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/year-variety/{lotCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getBreakdownByYearVariety (@PathVariable String lotCode) {
		logger.info("Get a breakdown of the TOTAL percentage grouped by year and variety for " + lotCode);
		Lot lot = new Lot();
		try {
			lot = breakdownService.readJSONFile(lotCode);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Response>(breakdownService.getBreakDownByYearAndVariety(lot), HttpStatus.OK);
	}
	

}
