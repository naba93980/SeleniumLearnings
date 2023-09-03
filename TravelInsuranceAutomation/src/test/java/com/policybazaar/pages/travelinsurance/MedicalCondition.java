package com.policybazaar.pages.travelinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MedicalCondition {
	
	private WebDriverWait wait;
	
	// WebElements on medical condition page using locators

	@FindBy(id = "ped_no")
	private WebElement no;
	
	
	// constructor initializes the elements using PageFactory class
	public MedicalCondition(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	// enter medical condition
	public void enterMedicalCondition() {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.no));
		this.no.click();
	}
}
