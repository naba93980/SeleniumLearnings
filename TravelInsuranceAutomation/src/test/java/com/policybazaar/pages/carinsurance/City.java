package com.policybazaar.pages.carinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class City {
	
	private WebDriverWait wait;
	
	// WebElements on city page using locators

	@FindBy(xpath = "//input[contains(@placeholder,'Search RTO')]")
	private WebElement city;

	@FindBy(id = "react-autowhatever-1--item-0")
	private WebElement cityItem;
	
	
	// constructor initializes the elements using PageFactory class
	public City(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	// enter name of city
	public void enterCity(String cityName) {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.city));
		this.city.clear();
		this.city.sendKeys(cityName);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.cityItem));
		this.cityItem.click();
	}
}
