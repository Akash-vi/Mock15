package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	private static WebDriver driver;
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "G:\\Akash\\Carrier\\Velocity\\Software\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "G:\\Akash\\Carrier\\Velocity\\Software\\geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver openMicroSoftEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "G:\\Akash\\Carrier\\Velocity\\Software\\msedgedriver.exe");
		driver = new EdgeDriver();
		return driver;
	}
	
	

}
