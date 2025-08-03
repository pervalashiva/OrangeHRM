package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddSkill extends BasePage {

	public AddSkill(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//a[.//span[text()='Admin']]")
	WebElement userAdmin;
	@FindBy(xpath = "//span[contains(text(),'Qualifications')]")
     WebElement qualification;

    @FindBy(xpath = "//a[text()='Skills']")
     WebElement skills;
    
    
	@FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
	WebElement addtitle;
	@FindBy(xpath= "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement giveTitle;
	@FindBy(xpath = "//textarea[@placeholder='Type description here']")
	WebElement jobDescription;
	
	 @FindBy(css = "input[type='file'].oxd-file-input")
     WebElement fileUploadInput;
	
	 @FindBy(css = "div.oxd-file-input-div")
	 WebElement fileSuccess;
	 

	 
	 public void admin()
	 {
		 userAdmin.click();
	 }
	 
	 public void dropdwn()
	 {
		 qualification.click();
		 skills.click();
	 }
	 
	 public void addTi()
	 {
		 addtitle.click();
	 }
	
	 public void uploadFile(String filePath) {
	        fileUploadInput.sendKeys(filePath);
	       
	        
	   }
	

}
