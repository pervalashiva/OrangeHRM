package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

class TC001_LoginPage extends BaseClass {
	 

	 @Test
	 public void verify_login()
	 {
		 
		 LoginPage lp = new LoginPage(driver); 
		 lp.userName("Admin");
		 lp.userPassword("admin123");
		 lp.userLogin();
		 Assert.assertTrue(lp.isLogoDisplayed(), "Logo is not displayed.");
	 }
	

}
