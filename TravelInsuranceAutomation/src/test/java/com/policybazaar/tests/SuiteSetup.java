package com.policybazaar.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.policybazaar.utils.DriverSetup;
import com.policybazaar.utils.ExtentReport;
import com.policybazaar.utils.InputData;
import com.policybazaar.utils.InputFile;


public class SuiteSetup {
	
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		
		try {
			driver = DriverSetup.setDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.policybazaar.com/");
			 InputData.inputWorkbook = InputFile.openInputWorkbook();
			ExtentReport.startReport();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@AfterSuite
	public void shutdown() {
		
		try {
			InputFile.closeInputWorkbook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
