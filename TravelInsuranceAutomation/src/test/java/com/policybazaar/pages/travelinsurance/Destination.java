package com.policybazaar.pages.travelinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Destination {
	
	private WebDriverWait wait;
	
	// WebElements on destination page using locators
	
	@FindBy(id = "country")
	private WebElement destination;
	
	@FindBy(xpath = "//ul[@class='search-list']/li[1]")
	private WebElement locationOption;
	
	@FindBy(className = "travel_main_cta")
	private WebElement nextButton;
	
	
	// constructor initializes the elements using PageFactory class
	public Destination(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	// enter destination location
	public void enterDestination(String location) {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.destination));
		this.destination.sendKeys(location);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.locationOption));
		this.locationOption.click();
	}
	
	
	// move to next page
	public void next() {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.nextButton));
		this.nextButton.click();;
	}
	
}
