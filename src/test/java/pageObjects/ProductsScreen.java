package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsScreen {

	WebDriver driver;

	public ProductsScreen(WebDriver driver) {

		this.driver = driver;
	}

	private By AddCartBtn = By.xpath("//button[text()='Add to cart']");
	private By shpCartLink = By.cssSelector("a[class='shopping_cart_link']");
	private By PrdScreenName = By.cssSelector("span[class='title']");
	
	public List<WebElement> getItemList() {
		return driver.findElements(By.cssSelector("div[class='inventory_item_name ']"));
	}

	public void addItemsToCart(List<String> data) {
		
		List<WebElement> itemList = getItemList();
		
		for (int i = 0; i < itemList.size(); i++) {

			String itemRetrived = itemList.get(i).getText();
			System.out.println(itemRetrived);

			if (data.contains(itemRetrived)) {
				driver.findElement(AddCartBtn).click();
			}
		}
	}

	public void goToYourCart() {
		
		driver.findElement(shpCartLink).click();
		
	}
	
	public String getProductScreenTitle() {
		
		return driver.findElement(PrdScreenName).getText();
	}
}
