package testCases;

import org.testng.annotations.Test;

import pageObjects.AddEmployee;

public class TC003_AddEmployee extends TC001_LoginPage{
	
	@Test
	public void verivy_addEmployee()
	{
		AddEmployee addemp = new AddEmployee(driver); 
		
		addemp.pim();
		addemp.aadd();
		addemp.firstName("Ram");
		addemp.middleName("rao");
		addemp.lastName("Kumar");
		addemp.toggle();
		addemp.username("ramkumar");
		addemp.passWord("test123");
		addemp.confrimPassword("test123");
		addemp.saveEmply();
		
	}

}
