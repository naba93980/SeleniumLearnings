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
		homePage.clickCarInsurance();
	}
	
	@Test(priority = 2)
	public void enterDestination() {
		destinationPage.enterDestination("Germany");
		destinationPage.next();
	}
	
	@Test(priority = 3)
	public void enterJourneyDates() {
		journeyDatesPage.enterDates("26 September, 2023", "26 October, 2023");
		journeyDatesPage.next();
	}
	
	@Test(priority = 4)
	public void enterMedicalCondition() {
		medicalConditionPage.enterMedicalCondition();
	}
	
	@Test(priority = 5)
	public void enterMobileNumber() {
		mobileNumberPage.enterMobileNumber("1234567890");
		mobileNumberPage.viewPlans();
	}
	
	@Test(priority = 6)
	public void insuranceDetails() {
		plansPage.getInsuranceDetails();
	}
	
}
