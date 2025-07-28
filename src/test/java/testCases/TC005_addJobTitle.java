package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.jobTitlePage;

public class TC005_addJobTitle extends TC001_LoginPage {
	
	@Test
	public void add_jobTitle() throws InterruptedException 
	{
		jobTitlePage addjobtitle = new jobTitlePage(driver);
		
		Thread.sleep(1000);
		addjobtitle.admin();
		Thread.sleep(1000);
		addjobtitle.dropdwn();
		Thread.sleep(1000);
		addjobtitle.addTi();
		
		addjobtitle.title();
		
		addjobtitle.description("OrangeHRM website making into automation ");
		Thread.sleep(1000);
		String path = "C:\\Users\\HI\\eclipse-workspace\\OrangeHRM\\screenshots\\LoginTestingBuild.jpeg";
		addjobtitle.uploadFile(path);
		Thread.sleep(1000);
		String uploadedName = addjobtitle.filesuccess();
		
	    Assert.assertEquals(uploadedName, "LoginTestingBuild.jpeg", "File upload failed!");
	    
	    Thread.sleep(1000);
	    addjobtitle.addNote("Creating the Job title");
	    addjobtitle.saveTitle();
	    Thread.sleep(2000);
		String savetitle = addjobtitle.getToastMessageText();
	    Assert.assertEquals(savetitle, "Successfully Saved", "Create Title failed!");
		
	}

}
