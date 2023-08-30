package com.policybazaar.pages.carinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHome {
	
	@FindBy(xpath = "//a[text()='Buying a new car? Click here']")
	private WebElement buyNewCar;
	
	public CarHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void buyNewCar() {
		this.buyNewCar.click();
	}
}
