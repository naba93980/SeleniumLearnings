package com.policybazaar.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.policybazaar.utils.DriverSetup;
import com.policybazaar.utils.ExtentReportManager;
import com.policybazaar.utils.InputData;
import com.policybazaar.utils.InputFile;
import com.policybazaar.utils.OutputFile;
import com.policybazaar.utils.ScreenShots;


public class SuiteSetup {
	
	public static WebDriver driver;
	
	@BeforeSuite(groups = {"smoke", "regression"})
	public void setUp() {
		
		try {
			driver = DriverSetup.setDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.policybazaar.com/");
			ScreenShots.setDriver(driver);
			ExtentReportManager.startReporting();
			InputData.inputWorkbook = InputFile.openInputWorkbook();
			OutputFile.createOutputFile();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@AfterSuite(groups = {"smoke", "regression"})
	public void shutdown() {
		
		try {
			driver.quit();
			InputFile.closeInputWorkbook();
			ExtentReportManager.flushReport();
			OutputFile.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
