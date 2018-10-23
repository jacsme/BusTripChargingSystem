package com.bustrip.business.object;

import java.util.ArrayList;
import java.util.List;

import com.bustrip.model.TripTransactionReport;

public class TripTransactionBO {
	/**
	 * Singleton is implemented to cater the reusability of the object and
	 * no need to instantiate it all the time unless it will be used again 
	 * as a clean list
	 */
	private static List<TripTransactionReport> INSTANCE;
	
	public static List<TripTransactionReport> getInstance() {
		if(INSTANCE == null){
			INSTANCE = new ArrayList<>();
        }
		return INSTANCE;
	}
	
	public static List<TripTransactionReport> reInstantiate() {
		return INSTANCE = new ArrayList<>();
	}
}
