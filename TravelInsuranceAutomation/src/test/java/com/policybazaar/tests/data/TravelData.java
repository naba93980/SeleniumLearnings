package com.policybazaar.tests.data;

import java.util.Map;

import org.testng.annotations.DataProvider;

import com.policybazaar.utils.InputData;

public class TravelData {
	
	// map to store data related to travel insurance
	public static Map<String, String> travelInsuranceData = InputData.getTravelInsuranceData();
	
	
	// Data provider methods gets data from the map and passes as arguments to test methods 

	@DataProvider(name = "destination")
	public static Object[][] destination() {

		String destination = travelInsuranceData.get("Destination");
		return new Object[][] { { destination }, };
	}
	
	
	@DataProvider(name = "journeyDates")
	public static Object[][] journeyDate() {
		
		String startDate = travelInsuranceData.get("StartDate");
		String endDate = travelInsuranceData.get("EndDate");
		return new Object[][] { { startDate, endDate }, };
	}
	
	
	@DataProvider(name = "phone")
	public static Object[][] phone() {
		
		String phoneNo = travelInsuranceData.get("Phone");
		return new Object[][] { { phoneNo }, };
	}
}
