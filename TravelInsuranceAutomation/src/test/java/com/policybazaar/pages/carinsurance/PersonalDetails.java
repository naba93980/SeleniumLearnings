package com.policybazaar.pages.carinsurance;

import java.util.List;

import org.openqa.selenium.Keys;
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
	
	@FindBy(id = "btnLeadDetails")
	private WebElement viewPlans;
	
	@FindBy(css = ".msg-error.show")
	private List<WebElement> invalidData;
	

	public PersonalDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPersonalDetails(String name, String email, String mobile) {
		this.fullName.sendKeys(name);
		this.email.sendKeys(email);
		this.mobileNo.sendKeys(mobile);
		this.mobileNo.sendKeys(Keys.RETURN);
		this.viewPlans.click();
	}
	
	public void getInvalidData() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Invalid messages :");
		
		for (WebElement invalidString : invalidData) {
			System.out.println(invalidString.getText());
		}
	}
}
