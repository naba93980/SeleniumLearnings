package com.policybazaar.pages.carinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHome {
	
	private WebDriverWait wait;
	
	// WebElements on car home page using locators 
	
	@FindBy(xpath = "//a[text()='Buying a new car? Click here']")
	private WebElement buyNewCar;
	
	
	// constructor initializes the elements using PageFactory class
	public CarHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	// select buy new car button
	public void buyNewCar() {
		
		this.wait.until(ExpectedConditions.elementToBeClickable(this.buyNewCar));
		this.buyNewCar.click();
	}
}
