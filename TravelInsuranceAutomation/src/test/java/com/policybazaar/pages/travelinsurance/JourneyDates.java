package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JourneyDates {
	
	@FindBy(xpath = "//label[text()='Start date']/following-sibling::div/input")
	private WebElement startdate;

	@FindBy(xpath = "//label[text()='End date']/following-sibling::div/input")
	private WebElement enddate;
	
	@FindBy(className = "travel_main_cta")
	private WebElement nextButton;
	
	public JourneyDates(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterDates(String startDate, String endDate) {
		this.startdate.sendKeys(startDate);
		this.enddate.sendKeys(endDate);
	}
	
	public void next() {
		this.nextButton.click();;
	}
}
