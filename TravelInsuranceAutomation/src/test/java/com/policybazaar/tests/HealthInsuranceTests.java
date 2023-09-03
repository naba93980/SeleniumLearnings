package com.policybazaar.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.policybazaar.pages.Home;
import com.policybazaar.pages.healthinsurance.ProductItems;
import com.policybazaar.utils.ExtentReportManager;
import com.policybazaar.utils.ScreenShots;

public class HealthInsuranceTests {

	// declare all page objects required for the tests
	private Home homePage;
	private ProductItems productItemMenu;
	private ExtentTest test;

	// create extent test for the tests
	@BeforeClass(groups = {"regression"})
	public void extentTestSetup() {
		test = ExtentReportManager.extentReport.createTest("Health Insurance");
	}

	// navigate to home
	@BeforeClass(groups = {"regression"})
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
	@BeforeClass(groups = {"regression"})
	public void initPages() {

		homePage = new Home(SuiteSetup.driver);
		productItemMenu = new ProductItems(SuiteSetup.driver);
	}

	// tests insurance product drop down menu
	@Test(priority = 1, groups = {"regression"})
	public void selectInsuranceProducts() {

		try {
			homePage.clickInsuranceProduct();
			test.pass("Clicked Insurance products");
			ScreenShots.takeScreenshot("Insurance_products", test);
		} catch (Exception e) {
			test.fail("Could not click Insurance products");
		}
	}

	// get all the health insurance products available
	@Test(priority = 2, groups = {"regression"})
	public void getHealthInsuranceProducts() {

		try {
			productItemMenu.listhealthInsuranceProducts();
			test.pass("Fetched health insurance products");
		} catch (Exception e) {
			test.fail("Could not fetch health insurance products");
		}
	}
}
