package com.bustrip.controller;


import static com.bustrip.constants.BusTripConstants.APPLICATION_JSON_API_VALUE;
import static com.bustrip.constants.BusTripConstants.SUBMIT_TRANSACTION_URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bustrip.model.TapData;
import com.bustrip.model.TripTransactionReport;
import com.bustrip.service.CalculateService;

/**
 * This is the main controller of Bus Trip Charging System
 * that will handle all the request or user inputs
 * @author Jack Lord Hermoso
 *
 */
@RestController
public class BusTripController {
	
	@Autowired
	private CalculateService calculateService;
	
	/**
	 * The api is accepting json for this project, this can be change to CSV if needed
	 * the request body will transform the json data into object
	 * @param tapDataListRequest
	 * @return tripTransactionReport
	 */
	@RequestMapping(value = SUBMIT_TRANSACTION_URI, method = RequestMethod.POST, produces = APPLICATION_JSON_API_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<TripTransactionReport>> computeBusTripTransaction(@RequestBody List<TapData> tapDataListRequest) {
		List<TripTransactionReport> tripTransactionReport = calculateService.computeBusTrip(tapDataListRequest);
		return ResponseEntity
	            .status(HttpStatus.OK)                 
	            .body(tripTransactionReport);
    }	
}
