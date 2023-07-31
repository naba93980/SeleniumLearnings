package com.irctc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	public static void main(String[] args) {
		// WebDriver driver=new EdgeDriver();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		
		CheckWebsite.verifyTitle(driver);
		TraverseSite.source(driver);
		TraverseSite.destination(driver);
		TraverseSite.date(driver);
		TraverseSite.journeyClass(driver);
	}
}
