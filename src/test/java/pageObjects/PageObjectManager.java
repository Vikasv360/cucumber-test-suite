package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LoginScreen loginScreen;
	public WebDriver driver;
	public ProductsScreen productsScreen;
	public YourCartScreen yourCartsScreen;
	public CheckoutYourInformation checkoutYourInformation;
	public CheckoutOverview checkoutOverview;
	public CheckoutComplete checkoutComplete;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
	}

	public LoginScreen getLoginScreen() {
		loginScreen = new LoginScreen(driver);
		return loginScreen;
	}

	public ProductsScreen getProductsScreen() {
		productsScreen = new ProductsScreen(driver);
		return productsScreen;
	}

	public YourCartScreen getYourCartScreen() {
		yourCartsScreen = new YourCartScreen(driver);
		return yourCartsScreen;
	}

	public CheckoutYourInformation getCheckoutYourInformation() {
		checkoutYourInformation = new CheckoutYourInformation(driver);
		return checkoutYourInformation;
	}

	public CheckoutOverview getCheckoutOverview() {
		checkoutOverview = new CheckoutOverview(driver);
		return checkoutOverview;
	}

	public CheckoutComplete getCheckoutComplete() {
		checkoutComplete = new CheckoutComplete(driver);
		return checkoutComplete;
	}
}
