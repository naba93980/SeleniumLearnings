package com.policybazaar.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.policybazaar.pages.Home;
import com.policybazaar.pages.carinsurance.CarDetails;
import com.policybazaar.pages.carinsurance.CarHome;
import com.policybazaar.pages.carinsurance.City;
import com.policybazaar.pages.carinsurance.PersonalDetails;


public class CarInsuranceTests {
	
	public Home homePage;
	public CarHome carHomePage;
	public City cityRTOPage;
	public CarDetails carDetailsPage; 
	public PersonalDetails personalDetailsPage;

	
	@BeforeClass
	public void navigateToHome() {
		SuiteSetup.driver.navigate().to("https://www.policybazaar.com/");
	}
	
	@BeforeClass
	public void initPages() {
		
		homePage = new Home(SuiteSetup.driver);
		carHomePage = new CarHome(SuiteSetup.driver);
		cityRTOPage = new City(SuiteSetup.driver);
		carDetailsPage = new CarDetails(SuiteSetup.driver);
		personalDetailsPage = new PersonalDetails(SuiteSetup.driver);
		
	}
	
	@Test(priority = 1)
	public void selectCarInsurance() {
		homePage.clickCarInsurance();
	}
	
	@Test(priority = 2)
	public void buyNewCar() {
		carHomePage.buyNewCar();
	}
	
	@Test(priority = 3)
	public void enterCity() {
		cityRTOPage.enterCity("Agartala");
	}
	
	@Test(priority = 4)
	public void enterCar() {
		carDetailsPage.enterCarName("Bolero");
		carDetailsPage.selectVariant();
	}
	
	@Test(priority = 5)
	public void enterPersonalDetails() {
		personalDetailsPage.enterPersonalDetails("Naba", "naba93980", "1234567890");
	}
	
	@Test(priority = 6)
	public void getInvalidData() {
		personalDetailsPage.getInvalidData();
	}
}
