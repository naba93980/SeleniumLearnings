package com.irctc;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainDetails {
	
	public static int trainsAvailable;

	public static void trainsAvailablity(WebDriver driver)throws InterruptedException{
		
		Thread.sleep(5000);
		
		List<WebElement> trains = driver.findElements(By.className("train-heading"));
		
		Thread.sleep(3000);
		
		trainsAvailable=trains.size();
		
		System.out.println("Total trains available: "+trainsAvailable);
		System.out.println("Name of Trains:");
//		for (WebElement train : trains) {
//			System.out.println(train.getText());
//		}
		for (int i = 1; i <= trains.size(); i++) {
			System.out.println(i+". "+trains.get(i-1).getText());
		}
	}
}
