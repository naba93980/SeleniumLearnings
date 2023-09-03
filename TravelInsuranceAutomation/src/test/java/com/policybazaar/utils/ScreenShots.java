package com.policybazaar.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

// class to take screenshots
public class ScreenShots {

	private static WebDriver driver;

	public static void setDriver(WebDriver driver) {
		ScreenShots.driver = driver;
	}

	public static String getScreenshotLocation() {
		Properties properties = ReadProperties.getProperties();
		String screenshotLocation = properties.getProperty("screenshotLocation");
		return screenshotLocation;
	}

	public static void takeScreenshot(String fileName, ExtentTest test) throws IOException {

		// type casting to ScreenShots interface
		TakesScreenshot screenShot = ((TakesScreenshot) driver);

		// creates the raw source file
		File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);

		// creates output destination file
		String filePath = getScreenshotLocation() + fileName + ".png";
		File destinationFile = new File(filePath);
		
		// copies file to destination file
		Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		test.addScreenCaptureFromPath(filePath);
	}
}
