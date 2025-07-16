package testCases;
import org.testng.annotations.Test;

import pageObjects.AddUser;

public class TC002_addUser extends TC001_LoginPage {
	

	@Test
	public void Verify_addUser()
	{
		AddUser adduser = new AddUser(driver);
		adduser.userAdmin();
		adduser.addUser();
		adduser.selectDropdownOptionByVisibleText("Admin");
		adduser.selectStatusEnabled();
		adduser.passwrod("test123");
		adduser.confirmpassword("test123");
		adduser.employeeName("Rakesh");
		adduser.username("Rakhee");
		adduser.save();
	}
	

}
