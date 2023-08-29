package com.policybazaar.pages.healthinsurance;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductItems {

	@FindBy(xpath = "//a[text()=\"Health Insurance\" and @class=\"headlink\"]/parent::h3/following-sibling::ul")
	public List<WebElement> insuranceProductlist;
	
	public ProductItems(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
 