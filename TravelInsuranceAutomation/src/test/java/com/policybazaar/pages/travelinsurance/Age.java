package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Age {
	
	@FindBy(id = "traveller_2")
	private WebElement countoftraveller;
	
	@FindBy(id="0")
	private WebElement travellerOne;
	
	@FindBy(id="21 years_undefined")
	private WebElement ageOne; 
	
	@FindBy(id="1")
	private WebElement travellerTwo;
	
	@FindBy(id="22 years_undefined")
	private WebElement ageTwo; 
	
	Age(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}