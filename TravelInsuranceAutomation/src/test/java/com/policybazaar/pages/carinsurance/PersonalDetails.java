package com.policybazaar.pages.carinsurance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.policybazaar.utils.OutputFile;

public class PersonalDetails {
	
	private WebDriverWait wait;
	
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
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterPersonalDetails(String name, String emailId, String mobile) {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.fullName));
		this.fullName.sendKeys(name);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.email));
		this.email.sendKeys(emailId);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.mobileNo));
		this.mobileNo.sendKeys(mobile);
		this.mobileNo.sendKeys(Keys.RETURN);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.viewPlans));
		this.viewPlans.click();
	}
	
	public void getInvalidData() {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(this.invalidData));

		System.out.println("Invalid messages :");
		for (WebElement invalidString : invalidData) {
			System.out.println(invalidString.getText());
		}
		
		OutputFile.CarInsurance.output(invalidData);
	}
}
