package com.policybazaar.pages.travelinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileNumber {

	private WebDriverWait wait;
	
	// WebElements on mobile number page using locators

	@FindBy(id = "mobileNumber")
	private WebElement mobileNumber;
	
	@FindBy(className = "travel_main_cta")
	private WebElement viewPlans;
	
	
	// constructor initializes the elements using PageFactory class
	public MobileNumber(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// enter mobile number
	public void enterMobileNumber(String number) {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.mobileNumber));
		this.mobileNumber.sendKeys(number);
	}
	
	
	// select to view available plans
	public void viewPlans() {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.viewPlans));
		this.viewPlans.click();;
	}
}
