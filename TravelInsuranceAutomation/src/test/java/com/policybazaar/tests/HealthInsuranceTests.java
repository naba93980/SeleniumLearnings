package com.policybazaar.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.policybazaar.pages.Home;
import com.policybazaar.pages.healthinsurance.ProductItems;

public class HealthInsuranceTests {

	public Home homePage;
	public ProductItems productItemMenu;
	
	@BeforeClass
	public void navigateToHome() {
		SuiteSetup.driver.navigate().to("https://www.policybazaar.com/");
	}

	@BeforeClass
	public void initPages() {

		homePage = new Home(SuiteSetup.driver);
		productItemMenu = new ProductItems(SuiteSetup.driver);

	}

	@Test(priority = 1)
	public void selectInsuranceProducts() {
		homePage.clickInsuranceProduct();
	}
	
	@Test(priority = 2)
	public void getHealthInsuranceProducts() {
		productItemMenu.listhealthInsuranceProducts();
	}

}
