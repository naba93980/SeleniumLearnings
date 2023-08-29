package com.policybazaar.hackathon;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// class to setup required driver
public class DriverSetup {

	public static WebDriver setDriver(char browser) {

		// creates chrome driver with certain options
		if (browser == 'C' || browser == 'c') {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments(Arrays.asList("--disable-notifications", "--start-maximized"));
			return new ChromeDriver(options);
		}

		// creates edge driver with certain options
		else {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments(Arrays.asList("start-maximized"));
			return new EdgeDriver(options);
		}
	}
}
