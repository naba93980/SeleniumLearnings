package com.irctc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainDetails {
	
	public static int trainsAvailable;

	public static void trainsAvailablity(WebDriver driver)throws InterruptedException{
		
		Thread.sleep(TraverseSite.latency);
		
		List<WebElement> trains = driver.findElements(By.className("train-heading"));
		
		Thread.sleep(TraverseSite.latency);
		
		trainsAvailable=trains.size();
		
		System.out.println("Total trains available: "+trainsAvailable);
		System.out.println("Name of Trains:");
		
		for (int i = 1; i <= trains.size(); i++) {
			
			WebElement trainElement=trains.get(i-1);
			Highlight.addHighlight(driver, trainElement);
			System.out.println(i+". "+trainElement.getText());
			Highlight.removeHighlight(driver, trainElement);
		}
	}
}
