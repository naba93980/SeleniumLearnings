package com.policybazaar.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.pages.Home;
import com.policybazaar.pages.carinsurance.CarDetails;
import com.policybazaar.pages.carinsurance.CarHome;
import com.policybazaar.pages.carinsurance.City;
import com.policybazaar.pages.carinsurance.PersonalDetails;
import com.policybazaar.utils.ExtentReportManager;
import com.policybazaar.utils.ScreenShots;

public class CarInsuranceTests {

	// declare all page objects required for the tests
	private Home homePage;
	private CarHome carHomePage;
	private City cityRTOPage;
	private CarDetails carDetailsPage;
	private PersonalDetails personalDetailsPage;
	private ExtentTest test;

	// create extent test for the tests
	@BeforeClass(groups = { "smoke", "regression" })
	public void extentTestSetup() {
		test = ExtentReportManager.extentReport.createTest("Car Insurance");
	}

	// navigate to home
	@BeforeClass(groups = { "smoke", "regression" })
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
	@BeforeClass(groups = { "smoke", "regression" })
	public void initPages() {

		homePage = new Home(SuiteSetup.driver);
		carHomePage = new CarHome(SuiteSetup.driver);
		cityRTOPage = new City(SuiteSetup.driver);
		carDetailsPage = new CarDetails(SuiteSetup.driver);
		personalDetailsPage = new PersonalDetails(SuiteSetup.driver);
	}

	// tests car insurance tab
	@Test(priority = 1, groups = { "regression", "smoke" })
	public void selectCarInsurance() {

		try {
			homePage.clickCarInsurance();
			test.pass("Navigated to Car Insurance");
		} catch (Exception e) {
			test.fail("Could not navigate to Car Insurance");
		}
	}

	// tests buy new car option
	@Test(priority = 2, groups = { "smoke" })
	public void buyNewCar() {

		try {
			carHomePage.buyNewCar();
			test.pass("Navigate to buy new car");
		} catch (Exception e) {
			test.fail("Could not navigate to buy new car");
		}
	}

	// tests city input
	@Test(priority = 3, groups = {"smoke" }, dataProvider = "city", dataProviderClass = com.policybazaar.tests.data.CarData.class)
	public void enterCity(String city) {

		try {
			cityRTOPage.enterCity(city);
			test.pass("City/RTO entered");
			ScreenShots.takeScreenshot("RTO", test);
		} catch (Exception e) {
			test.fail("Could not enter City/RTO");
		}
	}

	// tests car details inputs
	@Test(priority = 4, groups = {"smoke" }, dataProvider = "car", dataProviderClass = com.policybazaar.tests.data.CarData.class)
	public void enterCar(String car) {

		try {
			carDetailsPage.enterCarName(car);
			carDetailsPage.selectVariant();
			test.pass("Car details entered");
			ScreenShots.takeScreenshot("Car", test);
		} catch (Exception e) {
			test.fail("Could not enter car details");
		}
	}

	// tests personal details input
	@Test(priority = 5, groups = {"smoke" }, dataProvider = "personalDetails", dataProviderClass = com.policybazaar.tests.data.CarData.class)
	public void enterPersonalDetails(String name, String email, String mobile) {

		try {
			personalDetailsPage.enterPersonalDetails(name, email, mobile);
			test.pass("Personal details entered");
			ScreenShots.takeScreenshot("Personal_details", test);
		} catch (Exception e) {
			test.fail("Could not enter personal details");
		}
	}

	// gets all the invalid details entered
	@Test(priority = 6, groups = { "smoke" })
	public void getInvalidData() {

		try {
			personalDetailsPage.getInvalidData();
			test.pass("Fetched invalid details");
		} catch (Exception e) {
			test.fail("Could not fetch invalid details");
		}
	}
}
