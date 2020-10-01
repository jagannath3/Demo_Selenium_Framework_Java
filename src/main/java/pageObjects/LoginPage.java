package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	//achieving encapsulation by hiding the variables with private access modifier and accessing them with public methods below
	private By email=By.cssSelector("#modal_email");
	private By password=By.cssSelector("#modal_password");
	private By submit=By.cssSelector("#modal_login_submit");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}

	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickSubmit()
	{
		return driver.findElement(submit);
	}
}
