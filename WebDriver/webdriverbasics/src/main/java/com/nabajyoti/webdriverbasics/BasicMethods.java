package com.nabajyoti.webdriverbasics;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicMethods {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver chromeDriver = new ChromeDriver();

		chromeDriver.get("https://www.saucedemo.com");

		System.out.println(chromeDriver.getCurrentUrl());

		System.out.println(chromeDriver.getPageSource());

		System.out.println(chromeDriver.getTitle());

		String nString = chromeDriver.getWindowHandle();

		// WebDriver.Options.Window.maximize();
		chromeDriver.manage().window().maximize();

		// WebDriver.Navigation.navigation();
		chromeDriver.navigate().to("https://www.google.com");

		chromeDriver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");

		System.out.println(chromeDriver.getTitle());
		
		System.out.println(chromeDriver.getWindowHandle());
		
		System.out.println(nString);
		
		chromeDriver.switchTo().window(nString);

//		chromeDriver.quit();
	}
}
