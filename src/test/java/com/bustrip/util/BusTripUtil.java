 package com.bustrip.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.bustrip.model.TapData;

public class BusTripUtil {
	
	public static List<TapData> generateTapDataRequestlistStop1Stop2() {
    	
		List<TapData> tapdatalist = new ArrayList<>();
		
		TapData tapDataRequest = new TapData();
		tapDataRequest.setId(1);
		tapDataRequest.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:04:07.049"));
		tapDataRequest.setTapType("ON");
		tapDataRequest.setStopId("Stop 1");
		tapDataRequest.setBusId("Bus 37");
		tapDataRequest.setCompanyId("Company 1");
		tapDataRequest.setPan("550000555555559");
		tapdatalist.add(tapDataRequest);
		
		TapData tapDataRequest2 = new TapData();
		tapDataRequest2.setId(2);
		tapDataRequest2.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:09:07.049"));
		tapDataRequest2.setTapType("OFF");
		tapDataRequest2.setStopId("Stop 2");
		tapDataRequest2.setBusId("Bus 37");
		tapDataRequest2.setCompanyId("Company 1");
		tapDataRequest2.setPan("550000555555559");
		tapdatalist.add(tapDataRequest2);
		
    	return tapdatalist;
    }
	
	public static List<TapData> generateTapDataRequestlistStop2Stop3() {
    	
		List<TapData> tapdatalist = new ArrayList<>();
		
		TapData tapDataRequest = new TapData();
		tapDataRequest.setId(1);
		tapDataRequest.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:04:07.049"));
		tapDataRequest.setTapType("ON");
		tapDataRequest.setStopId("Stop 2");
		tapDataRequest.setBusId("Bus 37");
		tapDataRequest.setCompanyId("Company 1");
		tapDataRequest.setPan("550000555555559");
		tapdatalist.add(tapDataRequest);
		
		TapData tapDataRequest2 = new TapData();
		tapDataRequest2.setId(2);
		tapDataRequest2.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:09:07.049"));
		tapDataRequest2.setTapType("OFF");
		tapDataRequest2.setStopId("Stop 3");
		tapDataRequest2.setBusId("Bus 37");
		tapDataRequest2.setCompanyId("Company 1");
		tapDataRequest2.setPan("550000555555559");
		tapdatalist.add(tapDataRequest2);
		
    	return tapdatalist;
    }
	
	public static List<TapData> generateTapDataRequestlistStop1Stop3() {
    	
		List<TapData> tapdatalist = new ArrayList<>();
		
		TapData tapDataRequest = new TapData();
		tapDataRequest.setId(1);
		tapDataRequest.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:04:07.049"));
		tapDataRequest.setTapType("ON");
		tapDataRequest.setStopId("Stop 1");
		tapDataRequest.setBusId("Bus 37");
		tapDataRequest.setCompanyId("Company 1");
		tapDataRequest.setPan("550000555555559");
		tapdatalist.add(tapDataRequest);
		
		TapData tapDataRequest2 = new TapData();
		tapDataRequest2.setId(2);
		tapDataRequest2.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:09:07.049"));
		tapDataRequest2.setTapType("OFF");
		tapDataRequest2.setStopId("Stop 3");
		tapDataRequest2.setBusId("Bus 37");
		tapDataRequest2.setCompanyId("Company 1");
		tapDataRequest2.setPan("550000555555559");
		tapdatalist.add(tapDataRequest2);
		
    	return tapdatalist;
    }
	
	public static List<TapData> generateTapDataRequestlistWithInComplete() {
    	
		List<TapData> tapdatalist = new ArrayList<>();
		
		TapData tapDataRequest = new TapData();
		tapDataRequest.setId(1);
		tapDataRequest.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:04:07.049"));
		tapDataRequest.setTapType("ON");
		tapDataRequest.setStopId("Stop 1");
		tapDataRequest.setBusId("Bus 37");
		tapDataRequest.setCompanyId("Company 1");
		tapDataRequest.setPan("550000555555559");
		tapdatalist.add(tapDataRequest);
		
		TapData tapDataRequest2 = new TapData();
		tapDataRequest2.setId(2);
		tapDataRequest2.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:09:07.049"));
		tapDataRequest2.setTapType("OFF");
		tapDataRequest2.setStopId("Stop 2");
		tapDataRequest2.setBusId("Bus 37");
		tapDataRequest2.setCompanyId("Company 1");
		tapDataRequest2.setPan("550000555555559");
		tapdatalist.add(tapDataRequest2);
		
		TapData tapDataRequest3 = new TapData();
		tapDataRequest3.setId(3);
		tapDataRequest3.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:09:07.049"));
		tapDataRequest3.setTapType("ON");
		tapDataRequest3.setStopId("Stop 1");
		tapDataRequest3.setBusId("Bus 36");
		tapDataRequest3.setCompanyId("Company 2");
		tapDataRequest3.setPan("550000555555554");
		tapdatalist.add(tapDataRequest3);
		
    	return tapdatalist;
    }
	
	public static List<TapData> generateTapDataRequestlistStop1InComplete() {
    	
		List<TapData> tapdatalist = new ArrayList<>();
		
		TapData tapDataRequest = new TapData();
		tapDataRequest.setId(1);
		tapDataRequest.setDateTimeUTC(LocalDateTime.parse("2018-10-23T12:04:07.049"));
		tapDataRequest.setTapType("ON");
		tapDataRequest.setStopId("Stop 1");
		tapDataRequest.setBusId("Bus 37");
		tapDataRequest.setCompanyId("Company 1");
		tapDataRequest.setPan("550000555555553");
		tapdatalist.add(tapDataRequest);
		
    	return tapdatalist;
    }
}
