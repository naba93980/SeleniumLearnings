package model.pageobject.testsuite;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.pageobject.pages.LoginPage;
import utils.DriverSetup;

// POM with page factory and testng
public class TestMethodTestNG {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {

        driver = DriverSetup.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    public @Test void test() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
    }

    @AfterTest
    public void aftertest(){
        driver.quit();
    }
}
