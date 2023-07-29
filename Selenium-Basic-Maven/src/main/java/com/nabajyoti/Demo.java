package com.nabajyoti;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{
    public static void main( String[] args )
    {
        WebDriverManager.firefoxdriver().setup();                   // downloads firefox driver stores in .m2 cache, gets used below line to create firefoxDriver
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        ChromeDriver chromeDriver = new ChromeDriver();   // finds chrome driver in sytem env variable
        firefoxDriver.get("https://facebook.com");
        chromeDriver.get("https://google.com");
        chromeDriver.close();

    }
}
