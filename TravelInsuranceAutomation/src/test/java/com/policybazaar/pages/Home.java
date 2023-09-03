package com.policybazaar.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
	
	private WebDriverWait wait;
	
	// WebElements on home page using locators 
	
	@FindBy(xpath = "//section[@class='prd-row']/div[7]/a")
	private WebElement travelInsurance;
	
	@FindBy(xpath ="//section[@class='prd-row']/div[4]/a")
	private WebElement carInsurance;
	
	@FindBy(xpath = "//a[normalize-space()='Insurance Products']")
	private WebElement insuranceProduct;
	
	
	// constructor initializes the elements using PageFactory class
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	// interact with travel insurance option
	public void clickTravelInsurance() {
		
		wait.until(ExpectedConditions.elementToBeClickable(travelInsurance));
		this.travelInsurance.click();
	}
	
	// interact with car insurance option
	public void clickCarInsurance() {
		
		wait.until(ExpectedConditions.elementToBeClickable(carInsurance));
		this.carInsurance.click();
	}
	
	// interact with insurance products option
	public void clickInsuranceProduct() {
		
		wait.until(ExpectedConditions.elementToBeClickable(insuranceProduct));
		this.insuranceProduct.click();
	}
}
