package com.irctc.utils;

import java.util.Properties;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport {
	
	public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports extent;
	public static ExtentTest traverseTest;
	
	public static void startReport () { 
		
		Properties properties = ReadProperties.getProperties();
		String extentReportLoction = properties.getProperty("extentReportLoction");
		
		extentSparkReporter = new ExtentSparkReporter(extentReportLoction);
		extent = new ExtentReports();
		extent.attachReporter(extentSparkReporter);
		
		traverseTest = extent.createTest("Traverse");
		
	}
	
	public static void flushReport() {
		extent.flush(); 
	}
}
