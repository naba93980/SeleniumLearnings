package com.policybazaar.tests;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.policybazaar.utils.DriverSetup;
import com.policybazaar.utils.ExtentReport;
import com.policybazaar.utils.LoadInput;

public class SuiteSetup {
	
	public static WebDriver driver;
	public static XSSFWorkbook inputWorkbook;
	
	@BeforeSuite
	public void setUp() {
		
		try {
			driver = DriverSetup.setDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.policybazaar.com/");
//			inputWorkbook = LoadInput.getInputWorkbook();
			ExtentReport.startReport();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@AfterSuite
	public void shutdown() {
		driver.quit();
	}
}
