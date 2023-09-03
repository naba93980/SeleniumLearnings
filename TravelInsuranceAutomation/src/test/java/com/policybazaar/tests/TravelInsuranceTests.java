package com.policybazaar.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.pages.Home;
import com.policybazaar.pages.travelinsurance.Destination;
import com.policybazaar.pages.travelinsurance.JourneyDates;
import com.policybazaar.pages.travelinsurance.Age;
import com.policybazaar.pages.travelinsurance.MedicalCondition;
import com.policybazaar.pages.travelinsurance.MobileNumber;
import com.policybazaar.pages.travelinsurance.Plans;
import com.policybazaar.utils.ExtentReportManager;
import com.policybazaar.utils.ScreenShots;

public class TravelInsuranceTests {

	// declare all page objects required for the tests
	private Home homePage;
	private Destination destinationPage;
	private JourneyDates journeyDatesPage;
	private Age agePage;
	private MedicalCondition medicalConditionPage;
	private MobileNumber mobileNumberPage;
	private Plans plansPage;
	private ExtentTest test;

	// create extent test for the tests
	@BeforeClass(groups = {"smoke", "regression"})
	public void extentTestSetup() {
		test = ExtentReportManager.extentReport.createTest("Travel Insurance");
	}
	
	// navigate to home
	@BeforeClass(groups = {"smoke", "regression"})
	public void navigateToHome() {
		
		try {
			SuiteSetup.driver.manage().deleteAllCookies();
			SuiteSetup.driver.navigate().to("https://www.policybazaar.com/");
			test.pass("Navigated to homepage");
			ScreenShots.takeScreenshot("Homepage", test);
		} catch (Exception e) {
			test.fail("Failed to navigate to homepage");
		}
	}

	// initialize all the page objects
	@BeforeClass(groups = {"smoke", "regression"})
	public void initPages() {

		homePage = new Home(SuiteSetup.driver);
		destinationPage = new Destination(SuiteSetup.driver);
		journeyDatesPage = new JourneyDates(SuiteSetup.driver);
		agePage = new Age(SuiteSetup.driver);
		medicalConditionPage = new MedicalCondition(SuiteSetup.driver);
		mobileNumberPage = new MobileNumber(SuiteSetup.driver);
		plansPage = new Plans(SuiteSetup.driver);
	}


	// tests travel insurance tab
	@Test(priority = 1, groups = {"regression", "smoke"})
	public void selectTravelInsurance() {

		try {
			homePage.clickTravelInsurance();
			test.pass("Navigated to Travel Insurance");
		} catch (Exception e) {
			test.fail("Could not navigate to Travel Insurance");
		}
	}

	// tests destination tab
	@Test(priority = 2, groups = {"smoke"}, dataProvider = "destination", dataProviderClass = com.policybazaar.tests.data.TravelData.class)
	public void enterDestination(String destination) {

		try {
			destinationPage.enterDestination(destination);
			ScreenShots.takeScreenshot("Destination", test);
			destinationPage.next();
			test.pass("Destination entered");
		} catch (Exception e) {
			test.fail("Could not enter destination");
		}
	}

	// tests start and end date inputs
	@Test(priority = 3, groups = {"smoke"}, dataProvider = "journeyDates", dataProviderClass = com.policybazaar.tests.data.TravelData.class)
	public void enterJourneyDates(String startDate, String endDate) {

		try {
			journeyDatesPage.enterDates(startDate, endDate);
			ScreenShots.takeScreenshot("Journey_dates", test);
			journeyDatesPage.next();
			test.pass("Journey dates entered");
		} catch (Exception e) {
			test.fail("Could not enter journey dates");
		}
	}

	// tests age of travellers options
	@Test(priority = 4, groups = {"smoke"})
	public void selectTravellerDetails() {

		try {
			agePage.setTravellersCount();
			agePage.setAgeOfTravellerOne();
			agePage.setAgeOfTravellerTwo();
			ScreenShots.takeScreenshot("Traveller_details", test);
			agePage.next();
			test.pass("Traveller details selected");
		} catch (Exception e) {
			test.fail("Could not select traveller details");
		}
	}

	// tests medical condition options
	@Test(priority = 5, groups = {"smoke"})
	public void enterMedicalCondition() {

		try {
			medicalConditionPage.enterMedicalCondition();
			ScreenShots.takeScreenshot("Medical_condition", test);
			test.pass("Medical condition selected");
		} catch (Exception e) {
			test.fail("Could not select medical condition");
		}
	}

	// tests mobile number input
	@Test(priority = 6, groups = {"smoke"}, dataProvider = "phone", dataProviderClass = com.policybazaar.tests.data.TravelData.class)
	public void enterMobileNumber(String phoneNo) {

		try {
			mobileNumberPage.enterMobileNumber(phoneNo);
			ScreenShots.takeScreenshot("Mobile_Number", test);
			mobileNumberPage.viewPlans();
			test.pass("Mobile number entered");
		} catch (Exception e) {
			test.fail("Could not enter mobile number");
		}
	}

	// sorts the plan low to high and gets the details
	@Test(priority = 7, groups = {"smoke"})
	public void insuranceDetails() {

		try {
			plansPage.sortPlansLowToHigh();
			ScreenShots.takeScreenshot("Insurance_plans", test);
			plansPage.getInsuranceDetails();
			test.pass("Fetched details of travel insurance plans");
		} catch (Exception e) {
			test.fail("Could not fetch details of travel insurance plans");
		}
	}
}
