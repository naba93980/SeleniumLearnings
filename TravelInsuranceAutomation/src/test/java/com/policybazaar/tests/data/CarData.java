package com.policybazaar.tests.data;

import java.util.Map;

import org.testng.annotations.DataProvider;

import com.policybazaar.utils.InputData;

public class CarData {

	// map to store data related to car insurance
	public static Map<String, String> carInsuranceData = InputData.getCarInsuranceData();
	

	// Data provider methods gets data from the map and passes as arguments to test methods 
	
	@DataProvider(name = "city")
	public static Object[][] city() {

		String city = carInsuranceData.get("City");
		return new Object[][] { { city }, };
	}
	
	
	@DataProvider(name = "car")
	public static Object[][] car() {
		
		String city = carInsuranceData.get("Car");
		return new Object[][] { { city }, };
	}
	
	
	@DataProvider(name = "personalDetails")
	public static Object[][] personalDetails() {
		
		String name = carInsuranceData.get("Name");
		String email = carInsuranceData.get("Email");
		String mobile = carInsuranceData.get("Mobile");
		return new Object[][] { { name, email, mobile }, };
	}

}
