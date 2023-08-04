package com.irctc.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShots {
	public static void Screenshot(WebDriver driver, String fileName) throws IOException
	{
		TakesScreenshot screenShot = ((TakesScreenshot)driver);
		File Source = screenShot.getScreenshotAs(OutputType.FILE);
		String filePath="C:\\Users\\2282212\\OneDrive - Cognizant\\Desktop\\Naba\\InterimIRCTC\\"+fileName+".png";
		File Destination = new File(filePath);
		FileHandler.copy(Source, Destination);	
		System.out.println("Screenshot has been taken!");
	}
}
