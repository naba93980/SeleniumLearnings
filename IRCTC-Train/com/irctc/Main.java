package com.irctc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

//		System.out.println("Enter C for Google Chrome");
//		System.out.println("Enter E for Microsoft Edge");
//		char browser=null;
//		Scanner scanner = new Scanner(System.in);
//		
		

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
	}
}
