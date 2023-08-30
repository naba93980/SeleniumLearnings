package com.policybazaar.utils;

import java.util.Arrays;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// class to setup required driver
public class DriverSetup {

	public static WebDriver setDriver() {

		Properties properties = ReadProperties.getProperties();
        String browser = properties.getProperty("browser");
        
		// creates chrome driver with certain options
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments(Arrays.asList("--disable-notifications", "--start-maximized"));
//			String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36";
//			options.addArguments(String.format("user-agent=%s", userAgent));
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
