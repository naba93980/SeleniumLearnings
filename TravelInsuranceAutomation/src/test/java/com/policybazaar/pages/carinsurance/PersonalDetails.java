package com.policybazaar.pages.carinsurance;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails {
	
	@FindBy(id = "name")
	private WebElement fullName;

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "mobileNo")
	private WebElement mobileNo;
	
	@FindBy(css = ".msg-error.show")
	private List<WebElement> invalidData;
	
	@FindBy(id = "btnLeadDetails")
	private WebElement viewPlans;
	
	
	public PersonalDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setPersonalDetails(String name, String email, String mobile) {
		this.fullName.sendKeys(name);
		this.email.sendKeys(email);
		this.mobileNo.sendKeys(mobile);
	}
}
