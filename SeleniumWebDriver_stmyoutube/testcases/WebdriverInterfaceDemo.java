package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebdriverInterfaceDemo {

    public static String browser = "edge"; // take input
    public static WebDriver driver;

    public static void main(String[] args) {
        if (WebdriverInterfaceDemo.browser.equals("chrome")) {
            WebdriverInterfaceDemo.driver = new ChromeDriver();
        }
        if (WebdriverInterfaceDemo.browser.equals("edge")) {
            WebdriverInterfaceDemo.driver = new EdgeDriver();
        }
        driver.get("https://www.saucedemo.com/");
    }
}
