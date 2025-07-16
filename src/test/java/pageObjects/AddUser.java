package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser extends BasePage{

	public AddUser(WebDriver driver) {
		super(driver);
		
	}
	
@FindBy(xpath = "//a[.//span[text()='Admin']]")
WebElement userAdmin;
	
@FindBy(xpath = "//button[normalize-space()='Add']")
WebElement addUser;

@FindBy(xpath = "(//div[@class='oxd-select-text-input' and normalize-space(text())='-- Select --'])[1]")
WebElement dropdownTrigger;

// Clickable dropdown trigger (the box showing "Enabled")
@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
WebElement statusDropdown;

// Option inside the dropdown (visible after clicking)
@FindBy(xpath = "//div[@role='option']/span[text()='Enabled']")
WebElement enabledOption;

@FindBy(xpath = "(//input[@type='password'])[1]")
WebElement password;

@FindBy(xpath = "//input[@placeholder='Type for hints...']")
WebElement empName;

@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
WebElement userName;

@FindBy(xpath = "(//input[@type='password'])[2]")
WebElement confirmpassword;

@FindBy(xpath = "//button[normalize-space()='Save']")
WebElement btnsave;




public void userAdmin()
{
	userAdmin.click();
}
public void addUser()
{
	addUser.click();
}

public void selectDropdownOptionByVisibleText(String visibleText) {
    dropdownTrigger.click(); // open dropdown

    // Build dynamic XPath using visibleText argument
    String optionXpath = "//div[@role='option']//span[text()='" + visibleText + "']";

    // Find the option dynamically
    WebElement option = driver.findElement(By.xpath(optionXpath));

    option.click(); // select the option
}


public void selectStatusEnabled() {
    statusDropdown.click();       // Step 1: Open dropdown
    enabledOption.click();        // Step 2: Select "Enabled"
}

public void passwrod(String pwd)
{
	password.sendKeys(pwd);
}

public void employeeName(String EmployeName)
{
	empName.sendKeys(EmployeName);
}

public void username(String username)
{
	userName.sendKeys(username);
}

public void confirmpassword(String cnfpwd)
{
	confirmpassword.sendKeys(cnfpwd);
}
public void save()
{
	btnsave.click();
}
}
