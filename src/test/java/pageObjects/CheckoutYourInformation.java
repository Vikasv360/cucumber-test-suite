package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformation {

	WebDriver driver;

	public CheckoutYourInformation(WebDriver driver) {

		this.driver = driver;
	}
	
	private By checkoutYourInformationTitle = By.cssSelector("span[class='title']");
	private By firstname = By.id("first-name");
	private By lastname = By.id("last-name");
	private By postCode = By.id("postal-code");
	
	public String getCheckoutYourInformationTitle() {
		
		return driver.findElement(checkoutYourInformationTitle).getText();
	}
	
	public void enterCheckoutYourInformationDetails(String firstName,String lastName,String zipCode) {
		
		driver.findElement(firstname).sendKeys(firstName);
		driver.findElement(lastname).sendKeys(lastName);
		driver.findElement(postCode).sendKeys(zipCode);
	}
	
	public void goToCheckoutOverview() {
		driver.findElement(By.id("continue")).click();
	}
	
	
	
}
