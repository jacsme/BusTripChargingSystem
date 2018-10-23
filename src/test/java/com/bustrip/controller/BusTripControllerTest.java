package com.bustrip.controller;

import static com.bustrip.constants.BusTripConstantsTest.COMPUTE_BUSTRIP_RESPONSE_JSON;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bustrip.model.TapData;
import com.bustrip.model.TripTransactionReport;
import com.bustrip.service.CalculateService;
import com.bustrip.util.BusTripUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusTripControllerTest {

	@MockBean
    private CalculateService calculateService;

    private MockMvc mvc;
    
    @Mock
	private List<TapData> tapdatalistStop1Stop2;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }
     	
    @Test
    public void testComputeBusTripTransaction() throws Exception {
    	
    	tapdatalistStop1Stop2 =  BusTripUtil.generateTapDataRequestlistStop1Stop2();
    	List<TripTransactionReport> tripTransactionReportList = generateMockListResult();
    	
    	doReturn(tripTransactionReportList).when(calculateService).computeBusTrip(tapdatalistStop1Stop2);
        mvc.perform(post("/v1/submit/transaction")
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(COMPUTE_BUSTRIP_RESPONSE_JSON))
                .andExpect(status().isOk());
    }

	private List<TripTransactionReport> generateMockListResult() {
		List<TripTransactionReport> tripTransactionReportList = new ArrayList<>();
    	TripTransactionReport tripTransactionReport = new TripTransactionReport();
    	tripTransactionReport.setStarted(LocalDateTime.parse("2018-10-23T12:04:07.049"));
    	tripTransactionReport.setFinished(LocalDateTime.parse("2018-10-23T12:09:07.049"));
    	tripTransactionReport.setDurationSecs("0:5:0");
    	tripTransactionReport.setFromStopId("Stop 1");
    	tripTransactionReport.setToStopId("Stop 2");
    	tripTransactionReport.setChargeAmount(3.25);
    	tripTransactionReport.setCompanyId("Company 1");
    	tripTransactionReport.setBusId("Bus 37");
    	tripTransactionReport.setPan("550000555555559");
    	tripTransactionReport.setStatus("COMPLETED");
    	tripTransactionReportList.add(tripTransactionReport);
		return tripTransactionReportList;
	}
 }
