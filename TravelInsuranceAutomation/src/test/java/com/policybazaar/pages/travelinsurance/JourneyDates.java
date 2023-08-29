package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JourneyDates {
	
	@FindBy(xpath = "//label[text()='Start date']/following-sibling::div/input")
	public static WebElement startdate;

	@FindBy(xpath = "//label[text()='End date']/following-sibling::div/input")
	public static WebElement enddate;
	
	@FindBy(className = "travel_main_cta")
	public WebElement nextbutton;

}
