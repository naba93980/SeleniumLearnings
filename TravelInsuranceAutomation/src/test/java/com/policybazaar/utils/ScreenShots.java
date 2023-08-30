package com.policybazaar.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

// class to take screenshots
public class ScreenShots {

	public static String getScreenshotLocation() {
		Properties properties = ReadProperties.getProperties();
		String screenshotLocation = properties.getProperty("screenshotLocation");
		return screenshotLocation; 
	}

	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {

		// type casting to ScreenShots interface
		TakesScreenshot screenShot = ((TakesScreenshot) driver);

		// creates the raw source file
		File Source = screenShot.getScreenshotAs(OutputType.FILE);

		// creates output destination file
		String filePath = getScreenshotLocation() + fileName + ".png";
		File Destination = new File(filePath);

		// copies file to destination file
		FileHandler.copy(Source, Destination);
		System.out.println("Screenshot has been taken!");
	}
}

