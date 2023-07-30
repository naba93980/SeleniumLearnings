package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestDemo {
    public static void main(String[] args) {


        ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.saucedemo.com/");

        // get elements using id 
        By locatorUserName = By.id("user-name");        
        WebElement userName = chromeDriver.findElement(locatorUserName);
        
        By locatorPassword = By.id("password");        
        WebElement password = chromeDriver.findElement(locatorPassword);

        // put the values 
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        // get element using xpath
        chromeDriver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input")).click();
        // chromeDriver.close();

    }
}
