package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobTitlePage extends BasePage {

	public jobTitlePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//a[.//span[text()='Admin']]")
	WebElement userAdmin;
	@FindBy(xpath = "//span[contains(text(),'Job')]")
     WebElement jobTab;

    @FindBy(xpath = "//a[text()='Job Titles']")
     WebElement jobTitlesOption;
    
    
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
	 
	 @FindBy(xpath = "//textarea[@placeholder='Add note']")
	 WebElement text;
	 
	 @FindBy(xpath = "//button[normalize-space()='Save']")
	 WebElement save;
	 
	 @FindBy(xpath = "//p[contains(@class, 'oxd-toast-content-text') and text()='Successfully Saved']")
	 WebElement successToastMessage;

	 
	 public void admin()
	 {
		 userAdmin.click();
	 }
	 
	 public void dropdwn()
	 {
		 jobTab.click();
		 jobTitlesOption.click();
	 }
	 
	 public void addTi()
	 {
		 addtitle.click();
	 }
	 public String title() {
		    String uniqueTitle = "Job_" + RandomStringUtils.randomAlphanumeric(6);
		    giveTitle.sendKeys(uniqueTitle);
		    return uniqueTitle; // You can use this value in another class
	 }
	 public void description(String description)
	 {
		 jobDescription.sendKeys(description);
	 }
	
	 
	 public void uploadFile(String filePath) {
	        fileUploadInput.sendKeys(filePath);
	       
	        
	   }
	 public  String filesuccess() {
	      
	        return fileSuccess.getText();
	        
	   }
	 
	 public void  addNote(String AddNote)
	 {
		 
		  text.sendKeys(AddNote);
	 }
	public void saveTitle()
	{
		save.click();
	}
	public String getToastMessageText() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(successToastMessage));
	    return successToastMessage.getText();
	}
	
}
