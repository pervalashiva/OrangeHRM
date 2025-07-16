package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup() throws Exception {
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

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
