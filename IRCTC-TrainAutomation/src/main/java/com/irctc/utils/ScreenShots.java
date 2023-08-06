package com.irctc.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

// class to take screenshots
public class ScreenShots {
	public static void Screenshot(WebDriver driver, String fileName) throws IOException {

		// typecasting to ScreenShots interface
		TakesScreenshot screenShot = ((TakesScreenshot) driver);

		// creates the raw source file
		File Source = screenShot.getScreenshotAs(OutputType.FILE);

		// creates output destination file
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath + "\\Resources\\output\\" + fileName + ".png";
		File Destination = new File(filePath);

		// copies file to destination file
		FileHandler.copy(Source, Destination);
		System.out.println("Screenshot has been taken!");
	}
}
