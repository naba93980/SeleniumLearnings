package com.policybazaar.pages.travelinsurance;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plans {
	
	@FindBy(xpath = "//ul/li[2]")
	private WebElement sortBy;
	
	@FindBy(id = "17")
	private WebElement lowtohigh;
	
	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement apply;
	
	@FindBy(xpath = "//div[@class='quotesCard__planName']//p[1]")
	public List<WebElement> insuranceCompany;

	@FindBy(xpath = "//div[@class='quotesCard__planName']//p[2]")
	public List<WebElement> insuranceName;
	
	@FindBy(xpath = "//span[@class='premiumPlanPrice']")
	public List<WebElement> insurancePrice;

	public Plans(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
