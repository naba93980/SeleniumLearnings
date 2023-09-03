package com.policybazaar.pages.travelinsurance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.policybazaar.utils.OutputFile;

public class Plans {
	
	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[text()='Sort by']")
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
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void sortPlansLowToHigh() {
		
		wait.until(ExpectedConditions.elementToBeClickable(this.sortBy));
		this.sortBy.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(this.lowtohigh));
		this.lowtohigh.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(this.apply));
		this.apply.click();
	}
	
	public void getInsuranceDetails() {
		
		wait.until(ExpectedConditions.visibilityOfAllElements(insuranceName));
		wait.until(ExpectedConditions.visibilityOfAllElements(insurancePrice));
		wait.until(ExpectedConditions.visibilityOfAllElements(insuranceCompany));
		
		System.out.println("Details of 3 cheapest insurance plans :");
		
		for (int i = 1; i <= 3; i++) {
			System.out.printf("%d. %s offered at %s by company %s%n", i,this.insuranceName.get(i-1).getText(),this.insurancePrice.get(i-1).getText(), this.insuranceCompany.get(i-1).getText());
		}
		
		OutputFile.TravelInsurance.output(insuranceName, insurancePrice, insuranceCompany);
	}
}
