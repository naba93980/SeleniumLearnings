package com.policybazaar.pages.carinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarDetails {
	
	private WebDriverWait wait;
	
	// WebElements on car detail page using locators 

	@FindBy(xpath = "//input[@placeholder='Search car brand']")
	private WebElement car;
	
	@FindBy(id = "react-autowhatever-1--item-0")
	private WebElement carItem;
	
	@FindBy(xpath = "//li[@data-variantid='4944']")
	private WebElement variantId;
	
	
	// constructor initializes the elements using PageFactory class
	public CarDetails(WebDriver driver) {	
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// enter name of car
	public void enterCarName(String carName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.car));
		this.car.clear();
		this.car.sendKeys(carName);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.carItem));
		this.carItem.click();
	}
	
	// select variant of car
	public void selectVariant() {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.variantId));
		this.variantId.click();
	}
}
