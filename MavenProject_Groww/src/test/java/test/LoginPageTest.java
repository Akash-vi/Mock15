package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browser.Browser;
import pomClasses.HomePage;

public class LoginPageTest {
	private WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {

		if (browserName.equals("Chrome")) {
			driver = Browser.openChromeBrowser();
		}

		if (browserName.equals("Firefox")) {
			driver = Browser.openFirefoxBrowser();
		}

		if (browserName.equals("MicroSoftEdge")) {
			driver = Browser.openMicroSoftEdgeBrowser();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://groww.in/");
		HomePage homePage = new HomePage(driver);
		

	}

	@Test
	public void title() {
		System.out.println("DemoTest1");

	}

	@Test
	public void url() {
		System.out.println("DemoTest2");

	}

	@Test
	public void tagName() {
		System.out.println("DemoTest3");

	}

	@Test
	public void userNameTab() {
		System.out.println("DemoTest4");

	}

	@Test
	public void passwordTab() {
		System.out.println("DemoTest5");

	}

	@Test
	public void loginButton() {
		System.out.println("DemoTest6");

	}

	@Test
	public void createNewAcct() {
		System.out.println("DemoTest7");

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("after Method");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("after Test");

	}
}
