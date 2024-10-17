package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import utils.ResusableTestComponents;
import pageObjects.*;

public class StepDefinition {

	public int yourCartItem;
	ResusableTestComponents testdriver;
	CheckoutComplete checkoutComplete;
	CheckoutYourInformation checkoutYourInformation;

	public StepDefinition(ResusableTestComponents testdriver) {
		this.testdriver = testdriver;
	}

	@Then("User verifies the items in Your Cart screen")
	public void user_verifies_the_items_in_your_cart_screen() {

		YourCartScreen yourCartScreen = testdriver.pageObjects.getYourCartScreen();

		List<WebElement> yourCart = yourCartScreen.getYourCartItems();
		List<WebElement> items = yourCartScreen.getInventryList();

		ArrayList<String> itemValues = new ArrayList<String>();
		for (int i = 0; i < yourCart.size(); i++) {

			WebElement cartItem = yourCart.get(i);
			String value = items.get(i).getText();
			itemValues.add(value);

		}
		yourCartItem = itemValues.size();
	}

	@Then("User clicks on Checkout button")
	public void user_clicks_on_checkout_button() {

		YourCartScreen yourCartScreen = testdriver.pageObjects.getYourCartScreen();

		System.out.println(testdriver.NeededItemsSize);
		System.out.println("*********************************");
		System.out.println(yourCartItem);

		if (testdriver.NeededItemsSize == yourCartItem) {
			yourCartScreen.goToCheckOutYourInformation();
		}

	}

	@Then("User enters {string}, {string}, {string} in Checkout: Your Information screen")
	public void user_enters_in_checkout_your_information_screen(String firstName, String lastName, String zipCode) {

		checkoutYourInformation = testdriver.pageObjects.getCheckoutYourInformation();

		String expChkInfoScreen = "Checkout: Your Information";
		String actChkInfoScreen = checkoutYourInformation.getCheckoutYourInformationTitle();

		Assert.assertEquals(expChkInfoScreen, actChkInfoScreen);

		checkoutYourInformation.enterCheckoutYourInformationDetails(firstName, lastName, zipCode);

	}

	@Then("User clicks on Continue button")
	public void user_clicks_on_continue_button() {

		checkoutYourInformation.goToCheckoutOverview();
	}

	@Then("User verifies the price total in Checkout: Overview screen")
	public void user_verifies_the_price_total_in_checkout_overview_screen() {

		CheckoutOverview checkoutOverview = testdriver.pageObjects.getCheckoutOverview();

		String expChkOverScreen = "Checkout: Overview";
		String actChkOverScreen = checkoutOverview.getCheckoutOverviewtitle();
		Assert.assertEquals(expChkOverScreen, actChkOverScreen);

		List<WebElement> chkOutItemsPrices = checkoutOverview.getchkOutItemsPrices();
		ArrayList<Double> itemsPrices = new ArrayList<Double>();

		for (int i = 0; i < chkOutItemsPrices.size(); i++) {

			String priceTextString = chkOutItemsPrices.get(i).getText();

			String priceWithoutDollar = priceTextString.replace("$", "").trim();

			System.out.println(priceWithoutDollar);

			double itemPrice = Double.parseDouble(priceWithoutDollar);

			itemsPrices.add(itemPrice);
		}

		System.out.println(itemsPrices);
		double itemSum = 0.0;
		for (double price : itemsPrices) {
			itemSum = itemSum + price;
		}
		String subtotalText = checkoutOverview.getsubtotalText();
		String[] subtotalTextSplit = subtotalText.split("\\$"); // Escape the dollar sign
		String subtotalValue = subtotalTextSplit[1];
		double subtotalPrice = Double.parseDouble(subtotalValue);
		Assert.assertEquals(itemSum, subtotalPrice);
	}

	@Then("User verifies the success message in Checkout: Complete! screen")
	public void user_verifies_the_success_message_in_checkout_complete_screen() {

		checkoutComplete = testdriver.pageObjects.getCheckoutComplete();

		checkoutComplete.goCheckoutCompleteScreen();
		String actChkCmplt = checkoutComplete.getOrderSuccessText();
		String expChkCmplt = "Thank you for your order!";
		Assert.assertEquals(actChkCmplt, expChkCmplt);
	}

	@Then("User clicks Back Home button")
	public void user_clicks_back_home_button() {

		checkoutComplete.goHomeProductScreen();
	}

}
