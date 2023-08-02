package com.irctc;

import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		System.out.println("Enter C for Google Chrome");
		System.out.println("Enter E for Microsoft Edge");
		Scanner sc = new Scanner(System.in);
		char browser =  sc.next().charAt(0);
		sc.close();

		WebDriver driver = DriverSetup.setDriver(browser);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		CheckWebsite.verifyTitle(driver);
		TraverseSite.source(driver);
		TraverseSite.destination(driver);
		TraverseSite.date(driver);
		TraverseSite.journeyClass(driver);
		TraverseSite.disabilityConcession(driver);
		TraverseSite.findTrains(driver);
		TrainDetails.trainsAvailablity(driver);
		ScreenShots.Screenshot(driver);
	}
}
