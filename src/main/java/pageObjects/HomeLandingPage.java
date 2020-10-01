package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeLandingPage {

	public WebDriver driver;

	// achieving encapsulation by hiding the variables with private access modifier
	// and accessing them with public methods below
	private By Login = By.cssSelector("[class='btn btn-secondary home_page_login_button']");
	private By cities = By.xpath("(//div[@class='categories_container'])[1]//a");
	private By navbar = By.cssSelector("[class*='nav_menu_container']");
	private By links = By.cssSelector("[class*='scrollable_cards'] a");

	public HomeLandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(Login);
	}

	public List<WebElement> getCity() {
		return driver.findElements(cities);
	}

	public WebElement getNavBar() {
		return driver.findElement(navbar);
	}

	public List<WebElement> getLinks() {
		return driver.findElements(links);
	}
}
