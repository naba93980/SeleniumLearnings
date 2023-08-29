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
}
 