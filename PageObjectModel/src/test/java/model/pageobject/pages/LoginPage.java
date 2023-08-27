package model.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getUserNameElement() {
        return driver.findElement(By.id("user-name"));
    }

    private WebElement getPasswordElement() {
        return driver.findElement(By.id("password"));
    }

    private WebElement getLoginElement() {
        return driver.findElement(By.id("login-button"));
    }

    public void login(String username, String password){
        getUserNameElement().sendKeys(username);
        getPasswordElement().sendKeys(password);
        getLoginElement().click();
    }
}
