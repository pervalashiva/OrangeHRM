package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEmployee extends BasePage{

	public AddEmployee(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//span[normalize-space()='PIM']")
	WebElement pim;
	
	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement add;
	
	
	@FindBy(name = "firstName")
	WebElement fname;
		
	@FindBy(name="middleName")
	WebElement mname;

	@FindBy(name="lastName")
	WebElement lname;

	
	@FindBy(xpath = "//div[@class='oxd-switch-wrapper']")
	WebElement toggle;

	
	@FindBy(xpath = "//input[contains(@class, 'oxd-input') and @autocomplete='off']")
	WebElement userName;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement password;
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement cnfmpassword;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveEmployee;
	
	public void pim()
	{
		pim.click();
		
	}
	
	public void aadd()
	{
		add.click();
		
	}
	
	public void firstName(String firstName)
	{
		fname.sendKeys(firstName);
	}
	public void middleName(String mName)
	{
		mname.sendKeys(mName);
	}
	
	public void lastName(String lName)
	{
		lname.sendKeys(lName);
	}

	public void toggle()
	{
		toggle.click();
	}
	public void username(String uName)
	{
		userName.sendKeys(uName);
	}
	public void passWord(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void confrimPassword(String cpwd)
	{
		cnfmpassword.sendKeys(cpwd);
	}
	public void saveEmply()
	{
		saveEmployee.click();
	}
	

}
