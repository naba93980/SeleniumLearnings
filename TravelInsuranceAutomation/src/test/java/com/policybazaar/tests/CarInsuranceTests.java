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
	
	
	@Test(priority = 3, dataProvider = "city", dataProviderClass = com.policybazaar.tests.data.CarData.class)
	public void enterCity(String city) {
		cityRTOPage.enterCity(city);
	}
	
	
	@Test(priority = 4, dataProvider = "car", dataProviderClass = com.policybazaar.tests.data.CarData.class)
	public void enterCar(String car) {
		carDetailsPage.enterCarName(car);
		carDetailsPage.selectVariant();
	}
	
	
	@Test(priority = 5, dataProvider = "personalDetails", dataProviderClass = com.policybazaar.tests.data.CarData.class)
	public void enterPersonalDetails(String name, String email, String mobile) {	
		personalDetailsPage.enterPersonalDetails(name, email, mobile);
	}
	
	
	@Test(priority = 6)
	public void getInvalidData() {
		personalDetailsPage.getInvalidData();
	}
}
