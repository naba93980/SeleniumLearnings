package com.irctc;

import org.openqa.selenium.WebDriver;

import com.irctc.train.TrainDetails;
import com.irctc.train.TraverseSite;
import com.irctc.utils.LoadInput;
import com.irctc.utils.ReadInput;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {

		// choose browser
		System.out.println("Enter C for Google Chrome");
		System.out.println("Enter E for Microsoft Edge");
		Scanner sc = new Scanner(System.in);
		char browser = sc.next().charAt(0);
		sc.close();

		// sets driver and launches site
		WebDriver driver = DriverSetup.setDriver(browser);
		String url=ReadInput.urlInput();
		driver.get(url);
		
		// send command
		CheckWebsite.verifyTitle(driver);
		TraverseSite.source(driver);
		TraverseSite.destination(driver);
		TraverseSite.date(driver);
		TraverseSite.journeyClass(driver);
		TraverseSite.disabilityConcession(driver);
		TraverseSite.findTrains(driver);
		TrainDetails.trainsAvailablity(driver);
		LoadInput.closeInputWorkbook();

		// closes browser
		driver.close();
	}
}
