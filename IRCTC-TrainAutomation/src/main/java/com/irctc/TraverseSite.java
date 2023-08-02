package com.irctc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TraverseSite {

	public static WebElement source;
	public static WebElement destination;
	public static WebElement dateElement;
	public static WebElement classElement;
	public static WebElement disabilityElement;

	public static void source(WebDriver driver) throws InterruptedException {
		source = driver.findElement(By.cssSelector("input.ng-tns-c57-8"));
		source.sendKeys("Hyd");

		Thread.sleep(2000);
		
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
	}

	public static void destination(WebDriver driver) throws InterruptedException {
		destination = driver.findElement(By.cssSelector("input.ng-tns-c57-9"));
		destination.sendKeys("Pune");
		
		Thread.sleep(2000);

		destination.sendKeys(Keys.ENTER);
	}

	public static void date(WebDriver driver) throws InterruptedException {

		dateElement = driver.findElement(By.cssSelector("input.ng-tns-c58-10"));
		String currentDate = dateElement.getAttribute("value");
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(currentDate, myFormatter);
		String newDate = date.plusDays(4).format(myFormatter);
		
		Thread.sleep(3000);
		
		for (int i = 0; i < newDate.length(); i++) {
			dateElement.sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(1000);

		dateElement.sendKeys(newDate);
		driver.findElement(By.className("ui-state-active")).click();

	}

	public static void journeyClass(WebDriver driver) throws InterruptedException {

		classElement=driver.findElement(By.cssSelector(".ui-clickable.ng-tns-c65-11"));

		Thread.sleep(3000);

		classElement.click();
		driver.findElement(By.cssSelector("#journeyClass > div > div.ng-trigger.ng-trigger-overlayAnimation.ng-tns-c65-11.ui-dropdown-panel.ui-widget.ui-widget-content.ui-corner-all.ui-shadow.ng-star-inserted > div > ul > p-dropdownitem:nth-child(12) > li")).click();
		
	}
	
	public static void disabilityConcession(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.cssSelector("#concessionBooking + label")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("button.ui-confirmdialog-acceptbutton")).click();
	}
	
	public static void findTrains(WebDriver driver) {
		
		driver.findElement(By.className("train_Search")).click();
	}
}
