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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carHomePage.buyNewCar();
	}
	
	@Test(priority = 3)
	public void enterCity() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cityRTOPage.enterCity("Agartala");
	}
	
	@Test(priority = 4)
	public void enterCar() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carDetailsPage.enterCarName("Bolero");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carDetailsPage.selectVariant();
	}
	
	@Test(priority = 5)
	public void enterPersonalDetails() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalDetailsPage.enterPersonalDetails("Naba", "naba93980", "74391");
	}
	
	@Test(priority = 6)
	public void getInvalidData() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		personalDetailsPage.getInvalidData();
	}
}
