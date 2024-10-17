package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete {
	
	WebDriver driver;

	public CheckoutComplete(WebDriver driver) {

		this.driver = driver;
	}
	
	private By finishBtn = By.id("finish");
	private By orderLabel = By.xpath("//h2");
	private By homeBtn = By.xpath("//button[@name='back-to-products']");
	
	public void goCheckoutCompleteScreen() {
		driver.findElement(finishBtn).click();
	}
	
	public String getOrderSuccessText() {
		return driver.findElement(orderLabel).getText();
	}

	public void goHomeProductScreen() {
		driver.findElement(homeBtn).click();
	}
	
}
