package com.policybazaar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	@FindBy(xpath = "//section[@class=\"prd-row\"]/div[7]/a")
	private WebElement travelInsurance;
	
	@FindBy(xpath ="//section[@class=\"prd-row\"]/div[4]/a")
	private WebElement carInsurance;
	
	@FindBy(xpath = "//a[normalize-space()='Insurance Products']")
	private WebElement insurancProduct;
	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
