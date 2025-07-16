package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);	
		
	}
	
@FindBy(xpath = "//input[@placeholder='Username']")
WebElement usernameField;

@FindBy(xpath = "//input[@placeholder='Password']")
WebElement userpassword;

@FindBy(xpath = "//button[normalize-space()='Login']")
WebElement userLogin;

@FindBy(css = "div.oxd-brand-banner img")
WebElement brandLogo;

public void userName(String username)
{
	usernameField.sendKeys(username);
	
}

public void userPassword(String password)
{
	userpassword.sendKeys(password);
}

public void userLogin()
{
	userLogin.click();
}

public boolean isLogoDisplayed() {
    return brandLogo.isDisplayed();
}

}
