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

// class to traverse through the required elements
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

	// method to find the 'From' element and interact with it
	public static void source(WebDriver driver) throws InterruptedException, IOException {

		// gets the source input, finds the elements, sends keys
		sourceLocation = ReadInput.sourceInput();
		sourceElement = driver.findElement(By.cssSelector("input.ng-tns-c57-8"));
		sourceElement.sendKeys(sourceLocation);

		Highlight.addHighlight(driver, sourceElement);
		Thread.sleep(TraverseSite.latency);

		sourceElement.sendKeys(Keys.ARROW_DOWN);
		sourceElement.sendKeys(Keys.ENTER);

		ScreenShots.takeScreenshot(driver, "source");
		Highlight.removeHighlight(driver, sourceElement);
	}

	// method to find the 'To' element and and interact with it
	public static void destination(WebDriver driver) throws InterruptedException, IOException {
		
		// gets the source input, finds the elements, sends keys
		destinationLocation=ReadInput.destinationInput();
		destinationElement = driver.findElement(By.cssSelector("input.ng-tns-c57-9"));
		destinationElement.sendKeys(destinationLocation); 
		
		Highlight.addHighlight(driver, destinationElement);
		Thread.sleep(TraverseSite.latency);

		destinationElement.sendKeys(Keys.ENTER);
		
		ScreenShots.takeScreenshot(driver,"destination");
		Highlight.removeHighlight(driver, destinationElement);
	}

	// method to find the 'Date' element and and interact with it
	public static void date(WebDriver driver) throws InterruptedException, IOException {

		// finds the element, extracts current date value, adds required number of days
		dateElement = driver.findElement(By.cssSelector("input.ng-tns-c58-10"));
		String currentDate = dateElement.getAttribute("value");
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(currentDate, myFormatter);
		String newDate = date.plusDays(4).format(myFormatter);

		Thread.sleep(TraverseSite.latency);

		// deletes current date value
		for (int i = 0; i < newDate.length(); i++) {
			dateElement.sendKeys(Keys.BACK_SPACE);
		}

		Thread.sleep(TraverseSite.latency);
		Highlight.addHighlight(driver, dateElement);

		// sends new required date, clicks on the date on calendar 
		dateElement.sendKeys(newDate);
		driver.findElement(By.className("ui-state-active")).click();

		ScreenShots.takeScreenshot(driver, "journeyClass");
		Highlight.removeHighlight(driver, dateElement);

	}

	// method to select required seat class
	public static void journeyClass(WebDriver driver) throws InterruptedException, IOException {

		// gets the drop down arrow elements and clicks
		classDropdownArrow = driver.findElement(By.cssSelector(".ui-clickable.ng-tns-c65-11"));
		classDropdownArrow.click();
		
		// find the elements with class text to highlight
		highlightClassElement = driver.findElement(By.cssSelector(".ng-tns-c65-11.ui-dropdown-label.ui-inputtext"));
		Highlight.addHighlight(driver, highlightClassElement);
		
		Thread.sleep(TraverseSite.latency);

		// find the required class element and selects that
		classElement = driver.findElement(By.cssSelector("#journeyClass > div > div.ng-trigger.ng-trigger-overlayAnimation.ng-tns-c65-11.ui-dropdown-panel.ui-widget.ui-widget-content.ui-corner-all.ui-shadow.ng-star-inserted > div > ul > p-dropdownitem:nth-child(12) > li"));

//		Thread.sleep(TraverseSite.latency);

		classElement.click();

		ScreenShots.takeScreenshot(driver, "journeyClass");
		Highlight.removeHighlight(driver, highlightClassElement);
	}

	// method to select 'Person with disability' check box 
	public static void disabilityConcession(WebDriver driver) throws InterruptedException, IOException {

		driver.findElement(By.cssSelector("#concessionBooking + label")).click();

		Thread.sleep(TraverseSite.latency);

		driver.findElement(By.cssSelector("button.ui-confirmdialog-acceptbutton")).click();

		ScreenShots.takeScreenshot(driver, "disabilityConcession");
	}

	// method to find and click on search button
	public static void findTrains(WebDriver driver) {

		driver.findElement(By.className("train_Search")).click();
	}
}
