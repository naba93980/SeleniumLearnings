package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Destination {
	
	@FindBy(id = "country")
	private WebElement destination;
	
	@FindBy(xpath = "//ul[@class='search-list']/li[1]")
	private WebElement location;
	
	@FindBy(className = "travel_main_cta")
	private WebElement nextButton;
	
	public Destination(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterDestination(String location) {
		this.destination.sendKeys(location);
		this.location.click();
	}
	
	public void next() {
		this.nextButton.click();;
	}
	
}
