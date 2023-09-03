package com.policybazaar.utils;

import java.util.Properties;

//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.ExtentReports;

public class ExtentReportManager {
	
	public static ExtentHtmlReporter extentReporter;
	public static ExtentReports extentReport;
	
	public static void startReporting () { 
		
		Properties properties = ReadProperties.getProperties();
		String extentReportLoction = properties.getProperty("extentReportLoction");
		
		extentReporter = new ExtentHtmlReporter(extentReportLoction);
		extentReporter.config().setReportName("Policy Bazaar Report");
		extentReporter.config().setDocumentTitle("Policy Bazaar Automation");
		extentReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentReporter);
	}
	
	public static void flushReport() {
		extentReport.flush(); 
	}
}

