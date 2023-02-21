package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath = "(//div)[32]//span[1]//span")
	private WebElement loginButton;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean isDisplayedLoginButton() {
		return loginButton.isDisplayed();
	}
	public boolean isEnabledLoginButton() {
		 return loginButton.isEnabled();
	}
	
	public void clickOnLoginButton() {
		 loginButton.click();
	}
	
	public String getLabelLoginButton() {
		return loginButton.getText();
	}

}
