package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Age {
	
	@FindBy(xpath = "//label[@for='traveller_2']")
	private WebElement countoftraveller;
	
	@FindBy(id="0")
	private WebElement travellerOne;
	
	@FindBy(id="21 years_undefined")
	private WebElement ageOne; 
	
	@FindBy(id="1")
	private WebElement travellerTwo;
	
	@FindBy(id="22 years_undefined")
	private WebElement ageTwo; 
	
	@FindBy(className = "travel_main_cta")
	private WebElement nextButton;
	
	public Age(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void setTravellersCount() {
		this.countoftraveller.click();
	}
	
	public void setAgeOfTravellerOne() {
		this.travellerOne.click();
		this.ageOne.click();
	}
	
	public void setAgeOfTravellerTwo() {
		this.travellerTwo.click();
		this.ageTwo.click();
	}
	
	public void next() {
		this.nextButton.click();;
	}
}