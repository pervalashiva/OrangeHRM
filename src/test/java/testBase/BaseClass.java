package testBase;

import org.apache.logging.log4j.LogManager; //log4j2
import org.apache.logging.log4j.Logger;  //log4j2

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Logger logger;   //Log4j
    public Properties p;
    
    @BeforeClass
    @Parameters({"os", "browser"})
    public void setup(@Optional("windows") String os, @Optional("chrome") String br) throws Exception {
    	
    	//Loading config.properties files
    	
    	FileReader file = new FileReader("./src//test//resources//config.properties");
    	p= new Properties();
    	p.load(file);
    	
    	logger = LogManager.getLogger(this.getClass());
    	
        Path tempProfile = Files.createTempDirectory("chrome-profile");

        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection.enabled", false);
        prefs.put("password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        options.addArguments(
            "--disable-blink-features=PasswordLeakDetection",
            "--disable-features=PasswordLeakDetection",
            "--disable-password-manager-reauthentication",
            "--disable-save-password-bubble",
            "--user-data-dir=" + tempProfile.toAbsolutePath().toString(),
            "--incognito"
        );
        
        
        switch(br.toLowerCase())
        {
        case "chrome" : driver = new ChromeDriver(options); break;
        case "edge" :   driver = new EdgeDriver(); break;
        case "firefox" : driver = new FirefoxDriver(); break;
        default: System.out.println("Invallid browser name.."); return;
        }

        //driver = new ChromeDriver(options);
        
        
        
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL1")); // from properties file
        driver.manage().window().maximize(); 
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
