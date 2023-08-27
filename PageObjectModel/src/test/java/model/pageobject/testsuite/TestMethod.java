package model.pageobject.testsuite;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import model.pageobject.pages.LoginPage;
import utils.DriverSetup;

// POM with page factory and without testng
class TestMethod {
    public static void main(String[] args) {

        WebDriver driver = DriverSetup.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        driver.quit();
    }
}
