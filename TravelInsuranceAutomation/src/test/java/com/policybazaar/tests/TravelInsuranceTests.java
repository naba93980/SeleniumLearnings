package com.policybazaar.tests;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.policybazaar.pages.Home;
import com.policybazaar.pages.travelinsurance.Destination;
import com.policybazaar.pages.travelinsurance.JourneyDates;
import com.policybazaar.pages.travelinsurance.Age;
import com.policybazaar.pages.travelinsurance.MedicalCondition;
import com.policybazaar.pages.travelinsurance.MobileNumber;
import com.policybazaar.pages.travelinsurance.Plans;
import com.policybazaar.utils.DriverSetup;
import com.policybazaar.utils.ExtentReport;
import com.policybazaar.utils.LoadInput;

public class TravelInsuranceTests {

	public WebDriver driver;
	public XSSFWorkbook inputWorkbook;
	public Home homePage;
	public Destination destinationPage;
	public JourneyDates journeyDatesPage;
	public Age agePage;
	public MedicalCondition medicalConditionPage;
	public MobileNumber mobileNumberPage;
	public Plans plansPage;

	@BeforeSuite
	public void setUp() {
		
		try {
			driver = DriverSetup.setDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.policybazaar.com/");
			inputWorkbook = LoadInput.getInputWorkbook();
			ExtentReport.startReport();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@BeforeTest
	public void initPages() {
		
		homePage = new Home(driver);
		destinationPage = new Destination(driver);
		journeyDatesPage = new JourneyDates(driver);
		agePage = new Age(driver);
		medicalConditionPage = new MedicalCondition(driver);
		mobileNumberPage = new MobileNumber(driver);
		plansPage = new Plans(driver);
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
	
	@AfterSuite
	public void shutdown() {
		driver.quit();
	}
}
