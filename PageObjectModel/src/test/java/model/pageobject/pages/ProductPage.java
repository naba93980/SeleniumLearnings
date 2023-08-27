package model.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToBackPack() {
        driver.findElement(By.linkText("Sauce Labs Backpack")).click();
    }

    public void navigateToTShirt() {
        driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
    }

    public void navigateToJacket() {
        driver.findElement(By.linkText("Sauce Labs Fleece Jacket")).click();
    }

}
