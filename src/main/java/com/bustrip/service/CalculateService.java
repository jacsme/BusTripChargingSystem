package com.bustrip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bustrip.model.TapData;
import com.bustrip.model.TripTransactionReport;

@Service
public interface CalculateService {
	public List<TripTransactionReport> computeBusTrip(List<TapData> tapdatarequestlist);
}
