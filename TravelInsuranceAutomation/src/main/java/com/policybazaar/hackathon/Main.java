package com.policybazaar.hackathon;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import com.policybazaar.utils.ExtentReport;
import com.policybazaar.utils.ReadInput;

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
				
				// read input URL
				try {
					url = ReadInput.urlInput();
					driver.get(url);
					ExtentReport.traverseTest.log(Status.PASS, "URL loaded");
				} catch (Exception e) {
					e.printStackTrace();
					ExtentReport.traverseTest.log(Status.FAIL, e.getMessage());
				}
	}
}
