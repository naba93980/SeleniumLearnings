package com.policybazaar.pages.carinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarDetails {

	@FindBy(xpath = "//div[@id='searchInput']//input")
	private WebElement car;
	
	@FindBy(id = "react-autowhatever-1--item-0")
	private WebElement carItem;
	
	@FindBy(xpath = "//li[@data-variantid='4944']")
	private WebElement variantId;
	
	public CarDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterCarName(String carName) {
		this.car.sendKeys(carName);
		this.carItem.click();
	}
	
	public void selectVariant() {
		this.variantId.click();
	}
}
