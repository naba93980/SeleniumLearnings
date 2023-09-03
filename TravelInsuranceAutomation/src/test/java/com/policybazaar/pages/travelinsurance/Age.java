package com.policybazaar.pages.travelinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Age {

	private WebDriverWait wait;
	
	// WebElements on age page using locators

	@FindBy(xpath = "//label[@for='traveller_2']")
	private WebElement countoftraveller;

	@FindBy(id = "0")
	private WebElement travellerOne;

	@FindBy(xpath = "//label[@for='21 years_undefined']")
	private WebElement ageOne;

	@FindBy(id = "1")
	private WebElement travellerTwo;

	@FindBy(xpath = "//label[@for='22 years_undefined']")
	private WebElement ageTwo;

	@FindBy(className = "travel_main_cta")
	private WebElement nextButton;

	
	// constructor initializes the elements using PageFactory class
	public Age(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	// select number of travellers
	public void setTravellersCount() {

		wait.until(ExpectedConditions.elementToBeClickable(this.countoftraveller));
		this.countoftraveller.click();
	}

	
	// select age of first traveller
	public void setAgeOfTravellerOne() {

		wait.until(ExpectedConditions.elementToBeClickable(this.travellerOne));
		this.travellerOne.click();

		wait.until(ExpectedConditions.elementToBeClickable(this.ageOne));
		this.ageOne.click();
	}

	// select age of second traveller
	public void setAgeOfTravellerTwo() {

		wait.until(ExpectedConditions.elementToBeClickable(this.travellerTwo));
		this.travellerTwo.click();

		wait.until(ExpectedConditions.elementToBeClickable(this.ageTwo));
		this.ageTwo.click();
	}

	// move to next page
	public void next() {

		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		this.nextButton.click();
	}
}