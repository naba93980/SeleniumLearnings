package com.policybazaar.pages.healthinsurance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductItems {
	
	private WebDriverWait wait;

	@FindBy(xpath = "//div[@class='ruby-row']/div[3]//span")
	private List<WebElement> insuranceProductlist;
	
	public ProductItems(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void listhealthInsuranceProducts() {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(this.insuranceProductlist));
		
		System.out.println("List of Health Insurance products :");
		for (int i = 1; i <= this.insuranceProductlist.size(); i++) {
			System.out.printf("%d. %s%n", i,this.insuranceProductlist.get(i-1).getText());
		}
	}
}
