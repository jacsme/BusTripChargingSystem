package com.bustrip.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bustrip.business.object.BusTripBO;
import com.bustrip.business.object.TripTransactionBO;
import com.bustrip.model.TapData;
import com.bustrip.model.TripTransactionReport;
import com.bustrip.util.BusTripUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculateServiceImplTest {
	@InjectMocks
    @Spy
	private BusTripBO busTripBusinessObject = new BusTripBO();
	
	@InjectMocks
    @Spy
	private TripTransactionBO tripTransactionBusinessObject = new TripTransactionBO();
	
	@InjectMocks
	private CalculateService calculateServiceImpl = new CalculateServiceImpl();
	
	@Mock
	private List<TapData> tapdatalistWithIncomplete;
	
	@Mock
	private List<TapData> tapdatalistStop1Incomplete;
	
	@Mock
	private List<TapData> tapdatalistStop1Stop2;
	
	@Mock
	private List<TapData> tapdatalistStop2Stop3;
	
	@Mock
	private List<TapData> tapdatalistStop1Stop3;
	
	
	@Before
    public void setup() {
		tapdatalistWithIncomplete = BusTripUtil.generateTapDataRequestlistWithInComplete();
		tapdatalistStop1Incomplete = BusTripUtil.generateTapDataRequestlistStop1InComplete();
		tapdatalistStop1Stop2 = BusTripUtil.generateTapDataRequestlistStop1Stop2();
		tapdatalistStop2Stop3 = BusTripUtil.generateTapDataRequestlistStop2Stop3();
		tapdatalistStop1Stop3 = BusTripUtil.generateTapDataRequestlistStop1Stop3();
    }
	
	@Test
	public void testcomputeBusTripStop1Stop2() {
		List<TripTransactionReport> response = calculateServiceImpl.computeBusTrip(tapdatalistStop1Stop2);
		assertEquals(response.get(0).getChargeAmount(), Double.valueOf("3.25"));
		assertEquals(response.size(), 1);
	}
	
	@Test
	public void testcomputeBusTripStop2Stop3() {
		List<TripTransactionReport> response = calculateServiceImpl.computeBusTrip(tapdatalistStop2Stop3);
		assertEquals(response.get(0).getChargeAmount(), Double.valueOf("5.50"));
		assertEquals(response.size(), 1);
	}
	
	@Test
	public void testcomputeBusTripStop1Stop3() {
		List<TripTransactionReport> response = calculateServiceImpl.computeBusTrip(tapdatalistStop1Stop3);
		assertEquals(response.get(0).getChargeAmount(), Double.valueOf("7.30"));
		assertEquals(response.size(), 1);
	}
	
	@Test
	public void testcomputeBusTripWithIncomplete() {
		List<TripTransactionReport> response = calculateServiceImpl.computeBusTrip(tapdatalistWithIncomplete);
		assertEquals(response.size(), 2);
	}
	
	@Test
	public void testcomputeBusTripStop1InComplete() {
		List<TripTransactionReport> response = calculateServiceImpl.computeBusTrip(tapdatalistStop1Incomplete);
		assertEquals(response.get(0).getChargeAmount(), Double.valueOf("7.30"));
		assertEquals(response.size(), 1);
	}
	
}
