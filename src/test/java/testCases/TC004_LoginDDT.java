package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_LoginDDT extends BaseClass {
	
	 @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	 public void verify_login(String email, String pwd, String exp)
	 {
		 logger.info("***************verify login is started********************");
		 
		 
		 LoginPage lp = new LoginPage(driver); 
		 lp.userName(email);
		 lp.userPassword(pwd);
		 lp.userLogin();
		 Assert.assertTrue(lp.isLogoDisplayed(), "Logo is not displayed.");
		 lp.Logout();
		 logger.info("***************verify login is end********************");
		 
		 
		 logger.info("***************End********************");
	 }

}
