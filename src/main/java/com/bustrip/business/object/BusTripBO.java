package com.bustrip.business.object;

import java.util.ArrayList;
import java.util.List;

import com.bustrip.model.PriceTripData;

public class BusTripBO {
	/**
	 * This is BusTrip Business Object, this can be converted into Entity bean
	 * if we have jpa implemented and it will be mapped to a table. Just for this purpose
	 * I just manually inputed the values for validating the pricing
	 */
	private static List<PriceTripData> INSTANCE;
	
	public static List<PriceTripData> getInstance() {
		if(INSTANCE == null){
			INSTANCE = new ArrayList<>();
			PriceTripData priceTripData = new PriceTripData();
			priceTripData.setFromStopId("Stop 1");
			priceTripData.setToStopId("Stop 2");
			priceTripData.setChargeAmount(3.25);
			INSTANCE.add(priceTripData);
			
			PriceTripData priceTripData2 = new PriceTripData();
			priceTripData2.setFromStopId("Stop 2");
			priceTripData2.setToStopId("Stop 3");
			priceTripData2.setChargeAmount(5.50);
			INSTANCE.add(priceTripData2);
			
			PriceTripData priceTripData3 = new PriceTripData();
			priceTripData3.setFromStopId("Stop 1");
			priceTripData3.setToStopId("Stop 3");
			priceTripData3.setChargeAmount(7.30);
			INSTANCE.add(priceTripData3);
        }
		
		return INSTANCE;
	}
}
