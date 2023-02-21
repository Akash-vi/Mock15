package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "(//div)[39]//span[1]//span")
	private WebElement continueButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean isDisplayedContinueButton() {
		return continueButton.isDisplayed();
	}
	public boolean isEnabledContinueButton() {
		 return continueButton.isEnabled();
	}
	
	public void clickOnContinueButton() {
		 continueButton.click();
	}

}
