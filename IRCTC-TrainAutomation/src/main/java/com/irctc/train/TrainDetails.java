package com.irctc.train;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.irctc.utils.ScreenShots;
import com.irctc.utils.WriteOutput;

// class to retrieve train details and output them
public class TrainDetails {

	public static int trainsAvailable;
	public static WebElement trainElement;

	public static void trainsAvailablity(WebDriver driver) throws Exception {

		Thread.sleep(10000);

		// Finds all train web elements and puts them in list
		List<WebElement> trains = driver.findElements(By.className("train-heading"));

		Thread.sleep(TraverseSite.latency);

		trainsAvailable = trains.size();
		System.out.println("Total trains available: " + trainsAvailable);
		System.out.println("Name of Trains:");

		// prints on console train details
		for (int i = 1; i <= trains.size(); i++) {
			trainElement = trains.get(i - 1);
			System.out.println(i + ". " + trainElement.getText());
		}

		// Takes screenshot of trains available & calls output
		ScreenShots.takeScreenshot(driver, "result");
		WriteOutput.output(trains);
	}
}
