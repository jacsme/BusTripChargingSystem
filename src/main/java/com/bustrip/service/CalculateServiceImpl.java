package com.bustrip.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bustrip.business.object.BusTripBO;
import com.bustrip.business.object.TripTransactionBO;
import com.bustrip.model.PriceTripData;
import com.bustrip.model.TapData;
import com.bustrip.model.TripTransactionReport;

@Service
public class CalculateServiceImpl implements CalculateService{
	
	/**
	 * This service will process all the completed trips,
	 * there will be another process to calculate the incomplete trips,
	 * this is Lambda so there is not much issue with loops
	 */
	@Override
	public List<TripTransactionReport> computeBusTrip(List<TapData> tapdatarequestlist) {
		try {
			TripTransactionBO.reInstantiate();
			List<TapData> tapdatalist = tapdatarequestlist.stream()
					.collect(Collectors.toList());
			
			tapdatalist.forEach(tapdataItem ->{
				//Process the complete trips
				final List<TripTransactionReport> tripTransactionReportDetails = TripTransactionBO.getInstance().stream()
						.filter(triptransaction -> (triptransaction.getPan().equals(tapdataItem.getPan())) && (triptransaction.getStatus()==null))
					    .collect(Collectors.toList());
		
				if (tripTransactionReportDetails.isEmpty()) {
					TripTransactionReport tripTransactionReport = new TripTransactionReport();
					tripTransactionReport.setStarted(tapdataItem.getDateTimeUTC());
					tripTransactionReport.setFromStopId(tapdataItem.getStopId());
					tripTransactionReport.setCompanyId(tapdataItem.getCompanyId());
					tripTransactionReport.setBusId(tapdataItem.getBusId());
					tripTransactionReport.setPan(tapdataItem.getPan());
					TripTransactionBO.getInstance().add(tripTransactionReport);
				}else{
					tripTransactionReportDetails.get(0).setFinished(tapdataItem.getDateTimeUTC());
					tripTransactionReportDetails.get(0).setDurationSecs(calculateDuration(tripTransactionReportDetails.get(0).getStarted(), tapdataItem.getDateTimeUTC()));
					tripTransactionReportDetails.get(0).setToStopId(tapdataItem.getStopId());
					tripTransactionReportDetails.get(0).setChargeAmount(calculateCompleteChargeAmount(tripTransactionReportDetails.get(0).getFromStopId(), tapdataItem.getStopId()));
					tripTransactionReportDetails.get(0).setStatus("COMPLETED");
					//Send the payment here
				}
			});
			
		}catch (Exception e) {
			//TODO change this to Logger
			System.out.println(e.getMessage());
		}
		return computeInCompleteBusTrip();
	}
	
	public List<TripTransactionReport> computeInCompleteBusTrip() {
		List<TripTransactionReport> tripTransactionReportDetails = TripTransactionBO.getInstance().stream()
			    .collect(Collectors.toList());

		tripTransactionReportDetails.forEach(tripTransactionItem ->{
			if(tripTransactionItem.getStatus() == null) {
				tripTransactionItem.setDurationSecs(calculateDuration(tripTransactionItem.getStarted(), LocalDateTime.now()));
				tripTransactionItem.setChargeAmount(calculateIncompleteChargeAmount(tripTransactionItem.getFromStopId()));
				tripTransactionItem.setStatus("INCOMPLETE");
				//send the payment here
			}
		});
 
		return tripTransactionReportDetails;
	}
	
	private Double calculateCompleteChargeAmount(String fromStopId, String toStopId) {
		Double chargeAmountValue = null;
		List<PriceTripData> priceTrips = BusTripBO.getInstance();
		List<PriceTripData> busTripCompleteBO = priceTrips.stream()
				.filter(bustrip -> bustrip.getFromStopId().equals(fromStopId) && bustrip.getToStopId().equals(toStopId))
				.collect(Collectors.toList());
		
		chargeAmountValue = busTripCompleteBO.get(0).getChargeAmount();
		return chargeAmountValue;
	}
	
	private Double calculateIncompleteChargeAmount(String fromStopId) {
		Double chargeAmountValue = null;
		List<PriceTripData> priceTrips = BusTripBO.getInstance();
		List<PriceTripData> busTripInCompleteBO = priceTrips.stream()
				.filter(bustrip -> bustrip.getFromStopId().equals(fromStopId) || bustrip.getToStopId().equals(fromStopId))
				.collect(Collectors.toList());
		
		PriceTripData maxChargeAmount = busTripInCompleteBO.stream()
		        .max(Comparator.comparing(chargeamount -> chargeamount.getChargeAmount())).get();
		chargeAmountValue = maxChargeAmount.getChargeAmount();
		return chargeAmountValue;
	}
	
	private String calculateDuration(LocalDateTime started, LocalDateTime finished) {
		/*Separate LocaldateTime on LocalDate and LocalTime*/
	    LocalTime startedLocalTime = started.toLocalTime();
	    LocalTime finishedLocalTime = finished.toLocalTime();
	    long strhours = 0;
	    long strminutes = 0;
	    long strseconds = 0;
	    
	    /*Calculate the time difference*/
	    Duration duration = Duration.between(startedLocalTime, finishedLocalTime);
	    long durationDays = duration.toDays();
	    Duration throughoutTheDayDuration = duration.minusDays(durationDays);
	    strhours = throughoutTheDayDuration.toHours();
	    strminutes = throughoutTheDayDuration.toMinutes() % 60;
	    strseconds = throughoutTheDayDuration.getSeconds() % 60;
	    
		return strhours + ":" + strminutes + ":" + strseconds;
	}
}
