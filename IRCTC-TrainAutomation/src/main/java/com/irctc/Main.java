package com.irctc;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.irctc.train.TrainDetails;
import com.irctc.train.TraverseSite;
import com.irctc.utils.ExtentReport;
import com.irctc.utils.LoadInput;
import com.irctc.utils.ReadInput;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// choose browser
		System.out.println("Enter C for Google Chrome");
		System.out.println("Enter E for Microsoft Edge");
		Scanner sc = new Scanner(System.in);
		char browser = sc.next().charAt(0);
		sc.close();

		// sets driver and launches site
		WebDriver driver = DriverSetup.setDriver(browser);
		String url;
		
		// start report
		ExtentReport.startReport();
		
		// read input URL
		try {
			url = ReadInput.urlInput();
			driver.get(url);
			ExtentReport.traverseTest.log(Status.PASS, "URL loaded");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}

		
		// send commands and log if they pass or fail

		// verify website title
		try {
			CheckWebsite.verifyTitle(driver);
			ExtentReport.traverseTest.log(Status.PASS, "The site launch is correct!");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}

		// interact with "From" element
		try {
			TraverseSite.source(driver);
			ExtentReport.traverseTest.log(Status.PASS, "Source entered");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}

		// interact with "To" element
		try {
			TraverseSite.destination(driver);
			ExtentReport.traverseTest.log(Status.PASS, "Destination entered");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}

		// interact with "Date" element
		try {
			TraverseSite.date(driver);
			ExtentReport.traverseTest.log(Status.PASS, "Date entered");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}

		// interact with "Seat class" element
		try {
			TraverseSite.journeyClass(driver);
			ExtentReport.traverseTest.log(Status.PASS, "Journey seat class selected");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}
		
		// interact with "Person with disability box" element
		try {
			TraverseSite.disabilityConcession(driver);
			ExtentReport.traverseTest.log(Status.PASS, "Person with disablity selected");
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}
		
		// interact with "Search button" element
		TraverseSite.findTrains(driver);
		
		// Check available trains
		try {
			TrainDetails.trainsAvailablity(driver);
			ExtentReport.traverseTest.log(Status.PASS, "Screenshots taken and output saved");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		} 
		
		// Close input workbook
		try {
			LoadInput.closeInputWorkbook();
			ExtentReport.traverseTest.log(Status.PASS, "Workbook closed");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
		}
		
		// closes browser
		driver.close();
		
		// creates report file
		ExtentReport.flushReport();
	}
}
