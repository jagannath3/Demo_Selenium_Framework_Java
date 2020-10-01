package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.HomeLandingPage;
import pageObjects.LoginPage;
import resources.base;

public class LoginPageTest extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(LoginPageTest.class);

	@BeforeTest
	public void initDriver() throws IOException {

		driver = initializeDriver();
		log.info("Driver Initialized");
		// driver.get("https://internshala.com/");
		driver.get(System.getProperty("url")); // gets url from jenkins parameter / maven cmd (mvn test
												// -Durl="https://www.example.com")
		log.info("Navigated to Internshala Homepage");
	}

	@Test
	public void initLogin() {
		HomeLandingPage hp = new HomeLandingPage(driver);
		hp.getLogin().click();
		log.debug("Clicked the on Login button in the Home page");
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys("abc@gmail.com");
		log.debug("Entered Email ID");
		lp.getPassword().sendKeys("123456");
		log.debug("Entered Password");
		lp.clickSubmit().click();
		log.info("Clicked on Login button");
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
		log.info("Driver/Browser closed");
	}
}
