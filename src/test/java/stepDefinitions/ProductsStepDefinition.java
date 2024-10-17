package stepDefinitions;

import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ResusableTestComponents;
import pageObjects.*;

public class ProductsStepDefinition {

	ResusableTestComponents testdriver;
	public int NeededItemsSize;
	PageObjectManager pageObjects;
	ProductsScreen productsScreen;
	
	public ProductsStepDefinition(ResusableTestComponents testdriver) {
		this.testdriver=testdriver;
	}

	@Given("User is on the Swag Labs login screen")
	public void user_is_on_the_swag_labs_login_screen() {
	    
	}
	
	@When("User login with valid {string} and {string}")
	public void user_login_with_valid_and(String userName, String password) {
	
		LoginScreen loginScreen=testdriver.pageObjects.getLoginScreen();
		loginScreen.enterLoginDetails(userName, password);
		
	}

	@Then("User select list of items from products screen")
	public void user_select_list_of_items_from_products_screen(List<String> data) {
		
		ProductsScreen productsScreen= testdriver.pageObjects.getProductsScreen();
		
		testdriver.NeededItemsSize = data.size();	
		System.out.println(testdriver.NeededItemsSize);
		System.out.println("*****************************");

		productsScreen.addItemsToCart(data);
		
	}

	@Then("User clicks on the cart icon")
	public void user_clicks_on_the_cart_icon() {

		productsScreen= testdriver.pageObjects.getProductsScreen();
		productsScreen.goToYourCart();
		
	}

	@Then("User is displayed with Products screen")
	public void user_is_displayed_with_products_screen() {
		String exptHomePage = "Products";
		String actHomePage = productsScreen.getProductScreenTitle();
		Assert.assertEquals(exptHomePage, actHomePage);
	}
}
