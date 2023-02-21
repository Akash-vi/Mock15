package test;

import java.io.IOException;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browser.Browser;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import utils.Utility;

public class HomePageTest {
	private WebDriver driver;
	private HomePage homePage;
	private Actions act;
	private String testID;
	
	static ExtentTest test;
	static ExtentHtmlReporter reporter;

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {

		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		
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
		act = new Actions(driver);

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.groww.in/");
		homePage = new HomePage(driver);
	}

	@Test
	public void verifyLoginButtton() {
		testID = "TC001";
		SoftAssert soft = new SoftAssert();
		Assert.assertTrue(homePage.isDisplayedLoginButton());
		Assert.assertTrue(homePage.isEnabledLoginButton());
		String actualLabel = "Login/Register";
		String expectedLabel = homePage.getLabelLoginButton();
		Assert.assertEquals(actualLabel, expectedLabel);
		homePage.clickOnLoginButton();
		LoginPage loginPage = new LoginPage(driver);
		Assert.assertTrue(loginPage.isDisplayedContinueButton());
		act.sendKeys(Keys.ESCAPE);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			Utility.getScreenShot(driver, testID);
		}
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}
}
