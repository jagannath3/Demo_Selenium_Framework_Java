package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomeLandingPage;
import resources.base;

public class NavBarCheck extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(NavBarCheck.class);
	HomeLandingPage hp;

	@BeforeTest
	public void initDrive() throws IOException {
		driver = initializeDriver();
		log.info("Driver Initialized");
		// driver.get("https://internshala.com");
		driver.get(System.getProperty("url")); // gets url from jenkins parameter / maven cmd (mvn test
												// -Durl="https://www.example.com")
		log.info("Navigated to Internshala Homepage");
	}

	@Test
	public void navBarDisplay() {
		hp = new HomeLandingPage(driver);
		log.info("Checking NavBar is Displayed or not");
		Assert.assertFalse(hp.getNavBar().isDisplayed());
	}

	@Test
	public void getScrollableCardLinks() {
		hp = new HomeLandingPage(driver);
		log.info("Counting the scrallable cards links ");
		int size = hp.getLinks().size();
		Assert.assertEquals(size, 22);
		log.error("Scrollable counts do not match the expected count");
	}

	@AfterTest
	public void driverClose() {
		driver.close();
		log.info("Driver/Browser closed");
	}

}
