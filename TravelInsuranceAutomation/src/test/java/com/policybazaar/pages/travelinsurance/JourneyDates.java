package com.policybazaar.pages.travelinsurance;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JourneyDates {
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//label[text()='Start date']/following-sibling::div/input")
	private WebElement startdate;

	@FindBy(xpath = "//label[text()='End date']/following-sibling::div/input")
	private WebElement enddate;
	
	@FindBy(className = "travel_main_cta")
	private WebElement nextButton;
	
	public JourneyDates(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterDates(String startDate, String endDate) {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.startdate));
		this.startdate.sendKeys(startDate);
		
		wait.until(ExpectedConditions.elementToBeClickable(this.enddate));
		this.enddate.sendKeys(endDate);
	}
	
	public void next() {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.nextButton));
		this.nextButton.click();;
	}
}
