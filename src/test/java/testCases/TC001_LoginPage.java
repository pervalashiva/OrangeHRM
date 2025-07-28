package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

class TC001_LoginPage extends BaseClass {
	 

	 @Test
	 public void verify_login()
	 {
		 logger.info("***************verify login is started********************");
		 
		 try {
		 LoginPage lp = new LoginPage(driver); 
		 lp.userName("Admin");
		 lp.userPassword("admin123");
		 lp.userLogin();
		 
		 Assert.assertTrue(lp.isLogoDisplayed(), "Logo is not displayed.");
		 //lp.Logout();
		 logger.info("***************verify login is end********************");
		 }catch(Exception e)
		 {
			 logger.error("Test failed");
			 logger.debug("Debug logd*******");
			 Assert.fail();
		 }
		 
		 
		 logger.info("***************End********************");
	 }
	

}
