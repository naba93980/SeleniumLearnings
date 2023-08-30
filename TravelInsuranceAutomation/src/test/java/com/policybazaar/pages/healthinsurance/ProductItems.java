package com.policybazaar.pages.healthinsurance;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductItems {

	@FindBy(xpath = "//div[@class='ruby-row']/div[3]//span")
	private List<WebElement> insuranceProductlist;
	
	public ProductItems(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void listhealthInsuranceProducts() {
		
		System.out.println("List of Health Insurance products :");
		for (int i = 1; i <= this.insuranceProductlist.size(); i++) {
			System.out.printf("%d. %s", i,this.insuranceProductlist.get(i-1));
		}
	}
}
