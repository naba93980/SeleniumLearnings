package basic;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DemoAutomation {

	public static void main(String[] args) {
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://www.facebook.com");
		
		EdgeDriver edgeDriver = new EdgeDriver();
		edgeDriver.get("https://www.youtube.com");
	}

}
