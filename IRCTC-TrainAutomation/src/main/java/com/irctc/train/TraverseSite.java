package com.irctc.train;

import com.irctc.utils.Highlight;
import com.irctc.utils.ReadInput;
import com.irctc.utils.ScreenShots;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TraverseSite {

	public static int latency = 5000;
	public static String sourceLocation;
	public static String destinationLocation;
	public static WebElement sourceElement;
	public static WebElement destinationElement;
	public static WebElement dateElement;
	public static WebElement classElement;
	public static WebElement classDropdownArrow;
	public static WebElement highlightClassElement;
	public static WebElement disabilityElement;

	public static void source(WebDriver driver) throws InterruptedException, IOException {

		sourceLocation = ReadInput.sourceInput();
		sourceElement = driver.findElement(By.cssSelector("input.ng-tns-c57-8"));
		sourceElement.sendKeys(sourceLocation);

		Highlight.addHighlight(driver, sourceElement);

		Thread.sleep(TraverseSite.latency);

		sourceElement.sendKeys(Keys.ARROW_DOWN);
		sourceElement.sendKeys(Keys.ENTER);

		ScreenShots.Screenshot(driver, "source");

		Highlight.removeHighlight(driver, sourceElement);
	}

	public static void destination(WebDriver driver) throws InterruptedException, IOException {
		
		destinationLocation=ReadInput.destinationInput();
		destinationElement = driver.findElement(By.cssSelector("input.ng-tns-c57-9"));
		destinationElement.sendKeys(destinationLocation); 
		
		Highlight.addHighlight(driver, destinationElement);
		
		Thread.sleep(TraverseSite.latency);

		destinationElement.sendKeys(Keys.ENTER);
		
		ScreenShots.Screenshot(driver,"destination");
		
		Highlight.removeHighlight(driver, destinationElement);
	}

	public static void date(WebDriver driver) throws InterruptedException, IOException {

		dateElement = driver.findElement(By.cssSelector("input.ng-tns-c58-10"));
		String currentDate = dateElement.getAttribute("value");
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(currentDate, myFormatter);
		String newDate = date.plusDays(4).format(myFormatter);

		Thread.sleep(TraverseSite.latency);

		for (int i = 0; i < newDate.length(); i++) {
			dateElement.sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(TraverseSite.latency);

		Highlight.addHighlight(driver, dateElement);

		dateElement.sendKeys(newDate);
		driver.findElement(By.className("ui-state-active")).click();

		ScreenShots.Screenshot(driver, "journeyClass");

		Highlight.removeHighlight(driver, dateElement);

	}

	public static void journeyClass(WebDriver driver) throws InterruptedException, IOException {

		classDropdownArrow = driver.findElement(By.cssSelector(".ui-clickable.ng-tns-c65-11"));
		classDropdownArrow.click();

		highlightClassElement = driver.findElement(By.cssSelector(".ng-tns-c65-11.ui-dropdown-label.ui-inputtext"));
		Highlight.addHighlight(driver, highlightClassElement);

		Thread.sleep(TraverseSite.latency);

		classElement = driver.findElement(By.cssSelector("#journeyClass > div > div.ng-trigger.ng-trigger-overlayAnimation.ng-tns-c65-11.ui-dropdown-panel.ui-widget.ui-widget-content.ui-corner-all.ui-shadow.ng-star-inserted > div > ul > p-dropdownitem:nth-child(12) > li"));

		Thread.sleep(TraverseSite.latency);

		classElement.click();

		ScreenShots.Screenshot(driver, "journeyClass");

		Highlight.removeHighlight(driver, highlightClassElement);
	}

	public static void disabilityConcession(WebDriver driver) throws InterruptedException, IOException {

		driver.findElement(By.cssSelector("#concessionBooking + label")).click();

		Thread.sleep(TraverseSite.latency);

		driver.findElement(By.cssSelector("button.ui-confirmdialog-acceptbutton")).click();

		ScreenShots.Screenshot(driver, "disabilityConcession");
	}

	public static void findTrains(WebDriver driver) {

		driver.findElement(By.className("train_Search")).click();
	}
}
