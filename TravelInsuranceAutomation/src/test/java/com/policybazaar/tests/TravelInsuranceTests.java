package com.policybazaar.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.policybazaar.pages.Home;
import com.policybazaar.pages.travelinsurance.Destination;
import com.policybazaar.pages.travelinsurance.JourneyDates;
import com.policybazaar.pages.travelinsurance.Age;
import com.policybazaar.pages.travelinsurance.MedicalCondition;
import com.policybazaar.pages.travelinsurance.MobileNumber;
import com.policybazaar.pages.travelinsurance.Plans;

public class TravelInsuranceTests {

	public Home homePage;
	public Destination destinationPage;
	public JourneyDates journeyDatesPage;
	public Age agePage;
	public MedicalCondition medicalConditionPage;
	public MobileNumber mobileNumberPage;
	public Plans plansPage;

	@BeforeClass
	public void navigateToHome() {
		SuiteSetup.driver.navigate().to("https://www.policybazaar.com/");
	}
	
	@BeforeClass
	public void initPages() {
		
		homePage = new Home(SuiteSetup.driver);
		destinationPage = new Destination(SuiteSetup.driver);
		journeyDatesPage = new JourneyDates(SuiteSetup.driver);
		agePage = new Age(SuiteSetup.driver);
		medicalConditionPage = new MedicalCondition(SuiteSetup.driver);
		mobileNumberPage = new MobileNumber(SuiteSetup.driver);
		plansPage = new Plans(SuiteSetup.driver);
	}

	@Test(priority = 1)
	public void selectTravelInsurance() {
		homePage.clickTravelInsurance();
	}
	
	
	@Test(priority = 2, dataProvider = "destination", dataProviderClass = com.policybazaar.tests.data.TravelData.class )
	public void enterDestination(String destination) {
		destinationPage.enterDestination(destination);
		destinationPage.next();
	}
	
	
	@Test(priority = 3, dataProvider = "journeyDates", dataProviderClass = com.policybazaar.tests.data.TravelData.class)
	public void enterJourneyDates(String startDate, String endDate) {
		journeyDatesPage.enterDates(startDate, endDate);
		journeyDatesPage.next();
	}
	
	
	@Test(priority = 4)
	public void selectTravellerDetails() {
		agePage.setTravellersCount();
		agePage.setAgeOfTravellerOne();
		agePage.setAgeOfTravellerTwo();
		agePage.next();
	}
	
	
	@Test(priority = 5)
	public void enterMedicalCondition() {
		medicalConditionPage.enterMedicalCondition();
	}
	
	
	@Test(priority = 6)
	public void enterMobileNumber() {
		mobileNumberPage.enterMobileNumber("9000123456");
		mobileNumberPage.viewPlans();
	}
	
	
	@Test(priority = 7)
	public void insuranceDetails() {
		plansPage.sortPlansLowToHigh();
		plansPage.getInsuranceDetails();
	}
	
}
