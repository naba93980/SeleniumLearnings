package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileNumber {

	@FindBy(id = "mobileNumber")
	private WebElement mobileNumber;
	
	@FindBy(className = "travel_main_cta")
	private WebElement viewPlans;
	
	public MobileNumber(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(String number) {
		this.mobileNumber.sendKeys(number);
	}
	
	public void viewPlans() {
		this.viewPlans.click();;
	}
}
