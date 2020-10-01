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

public class HomePageTest extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(HomePageTest.class);
	// public WebDriver driver;
	// public Properties prop;

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
	public void selectCity() {

		// hp.getLogin().click();
		HomeLandingPage hp = new HomeLandingPage(driver);
		log.info("Searching for the city");
		int size = hp.getCity().size();
		for (int i = 0; i < size; i++) {
			if (hp.getCity().get(i).getText().contains("Bangalore")) {
				hp.getCity().get(i).click();
				log.debug("Clicked the on desired city");
				break;
			}
		}
	}

	@AfterTest
	public void driverClose() {
		driver.close();
		log.info("Driver/Browser closed");
	}

}
