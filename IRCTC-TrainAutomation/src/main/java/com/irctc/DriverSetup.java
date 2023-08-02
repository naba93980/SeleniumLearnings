package com.irctc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver setDriver(char browser) {
		if (browser == 'C' || browser == 'c')
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			return new ChromeDriver(options);
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		}
	}
}
