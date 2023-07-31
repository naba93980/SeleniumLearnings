package com.irctc;

import org.openqa.selenium.WebDriver;

public class CheckWebsite {
	public static void verifyTitle(WebDriver driver) {
		String siteTitle = "IRCTC Next Generation e-Ticketing System";
		String receivedTitle = driver.getTitle();
		System.out.println(siteTitle);
		if(siteTitle.equalsIgnoreCase(receivedTitle))
		{
			System.out.println("The site launch is incorrect!");
		}
		else
		{
			System.out.println("The site launch is correct!");
		}
	}
}
