package model.pageobject.testsuite;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import model.pageobject.pages.LoginPage;
import model.pageobject.pages.ProductPage;
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

    @Test(priority = 1)
    public void testLoginPage() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void testProductPage() throws InterruptedException{
        ProductPage productPage = new ProductPage(driver);
        productPage.navigateToBackPack();
        Thread.sleep(2000);
    }

    @AfterTest
    public void aftertest(){
        driver.quit();
    }
}
