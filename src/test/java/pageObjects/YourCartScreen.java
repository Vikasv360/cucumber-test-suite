package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartScreen {
	
	WebDriver driver;

	public YourCartScreen(WebDriver driver) {

		this.driver = driver;
	}
	
	private By chkBtn = By.id("checkout");

    public List<WebElement> getYourCartItems() {
    	return driver.findElements(By.className("cart_item"));
    }
    
    public List<WebElement> getInventryList() {
    	return driver.findElements(By.className("inventory_item_name"));
    }
    
    public void goToCheckOutYourInformation() {
    	driver.findElement(By.id("checkout")).click();
    }
    
	
}
