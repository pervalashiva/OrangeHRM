package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC004_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verify_login(String email, String pwd, String exp) {
        logger.info("***************verify loginData is started********************");

        try {
            LoginPage lp = new LoginPage(driver);
            lp.userName(email);
            lp.userPassword(pwd);
            lp.userLogin();

            // Check if the logo is displayed
            boolean isLogoDisplayed = lp.isLogoDisplayed();
            Assert.assertTrue(isLogoDisplayed, "Logo is not displayed.");

            // If login is valid, logo should be displayed and then logout
            if (exp.equalsIgnoreCase("valid")) {
                if (isLogoDisplayed) {
                    logger.info("Login successful. Performing logout.");
                    lp.Logout();
                    Assert.assertTrue(true, "Logout successful after valid login.");
                } else {
                    Assert.assertTrue(false, "Logo is not displayed after valid login.");
                }
            }
            // If login is invalid, logo should not be displayed
            else if (exp.equalsIgnoreCase("invalid")) {
                if (!isLogoDisplayed) {
                    logger.info("Login failed as expected. Logo is not displayed.");
                    Assert.assertTrue(true, "Login failed and logo is not displayed for invalid credentials.");
                } else {
                    Assert.assertTrue(false, "Logo is displayed even after invalid login.");
                }
            }
        } catch (Exception e) {
            logger.error("An exception occurred during the test execution: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }

        logger.info("***************End********************");
    }
}
