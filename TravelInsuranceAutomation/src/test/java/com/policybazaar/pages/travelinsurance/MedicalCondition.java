package com.policybazaar.pages.travelinsurance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicalCondition {
	
	@FindBy(id = "ped_no")
	private WebElement no;
	
	public MedicalCondition(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMedicalCondition() {
		this.no.click();
	}
}
