package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverview {

	WebDriver driver;

	public CheckoutOverview(WebDriver driver) {

		this.driver = driver;
	}

	private By checkoutOverviewtitle = By.cssSelector("span[class='title']");
	private By chkOutItemsPricesList = By.className("inventory_item_price");
	private By subtotalText = By.className("summary_subtotal_label");

	public String getCheckoutOverviewtitle() {

		return driver.findElement(checkoutOverviewtitle).getText();
	}

	public List<WebElement> getchkOutItemsPrices() {
		return driver.findElements(chkOutItemsPricesList);
	}

	public String getsubtotalText() {
		return driver.findElement(subtotalText).getText();
	}
}
