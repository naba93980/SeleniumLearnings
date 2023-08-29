package com.policybazaar.pages.carinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class City {

	@FindBy(xpath = "//[@id=searchInput]//input")
	private WebElement city;

	@FindBy(id = "react-autowhatever-1--item-0")
	private WebElement cityItem;
	
	public City(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
