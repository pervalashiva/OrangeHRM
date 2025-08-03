package testCases;
import pageObjects.AddSkill;
import pageObjects.jobTitlePage;

public class TC006_addSkill extends TC001_LoginPage {

	
	
	public void verify_addskill()
	{
	AddSkill addskill = new AddSkill(driver);
		
	Thread.sleep(1000);
	addskill.admin();
	Thread.sleep(1000);
	addskill.dropdwn(); 
	Thread.sleep(1000);
	addskill.addTi();
	
	addskill.title();
	
	addskill.description("OrangeHRM website making into automation ");
	Thread.sleep(1000);

	
	}	
}
