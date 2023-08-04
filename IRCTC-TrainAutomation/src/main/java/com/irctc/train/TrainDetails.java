package com.irctc.train;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.irctc.utils.ScreenShots;
import com.irctc.utils.WriteOutput;


public class TrainDetails {
	
	public static int trainsAvailable;

	public static void trainsAvailablity(WebDriver driver)throws InterruptedException, IOException{
		
		Thread.sleep(10000);
		
		List<WebElement> trains = driver.findElements(By.className("train-heading"));
		
		Thread.sleep(TraverseSite.latency);
		
		trainsAvailable=trains.size();
		
		System.out.println("Total trains available: "+trainsAvailable);
		System.out.println("Name of Trains:");
		
		for (int i = 1; i <= trains.size(); i++) {
			WebElement trainElement=trains.get(i-1);
			System.out.println(i+". "+trainElement.getText());
		}
		
		ScreenShots.Screenshot(driver,"result");
		WriteOutput.output(trains);
	}
}
