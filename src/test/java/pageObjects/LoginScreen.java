package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginScreen {
	WebDriver driver;
	
	public LoginScreen(WebDriver driver){
		
		this.driver=driver;
	}

	private By userId = By.id("user-name");
	private By passWord = By.id("password");
	private By lgnButton = By.id("login-button");
	
	public void enterLoginDetails(String userName, String password) {
		driver.findElement(userId).sendKeys(userName);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(lgnButton).click();
	}
}
