package com.irctc;

import org.openqa.selenium.WebDriver;

import com.irctc.utils.ReadInput;

// class to verify if the tiltle of the website
public class CheckWebsite {
	public static void verifyTitle(WebDriver driver) {
		String siteTitle = ReadInput.siteTitleInput();
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
