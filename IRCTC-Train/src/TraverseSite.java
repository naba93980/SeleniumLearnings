package com.irctc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TraverseSite {
	
	public static WebElement source;
	public static WebElement destination;
	public static WebElement dateElement;
	
	public static void source(WebDriver driver){
		source =driver.findElement(By.cssSelector("input.ng-tns-c57-8"));
		source.sendKeys("Hyd");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		source.sendKeys(Keys.ARROW_DOWN);
		source.sendKeys(Keys.ENTER);
	}
	
	public static void destination(WebDriver driver) {
		destination=driver.findElement(By.cssSelector("input.ng-tns-c57-9"));
		destination.sendKeys("Pune");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		destination.sendKeys(Keys.ENTER);
	}
	
	public static void date(WebDriver driver) {
		
		dateElement=driver.findElement(By.cssSelector("input.ng-tns-c58-10"));
		String currentDate=dateElement.getAttribute("value");
		DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date=LocalDate.parse(currentDate,myFormatter);
		String newDate=date.plusDays(4).format(myFormatter);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		dateElement.clear();
		for (int i = 0; i < newDate.length(); i++) {
			dateElement.sendKeys(Keys.BACK_SPACE); 
		}
		dateElement.sendKeys(newDate); 
		
		
	}
}
