package com.irctc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver setDriver(char browser) {
		if (browser == 'C' || browser == 'c')
		{
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		}
	}
}
