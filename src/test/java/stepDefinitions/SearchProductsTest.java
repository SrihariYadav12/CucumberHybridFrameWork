package stepDefinitions;

import org.testng.Assert;

import hooks.Myhooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.SearchResultPage;

public class SearchProductsTest extends Myhooks {
	private HomePage homepage;
	private SearchResultPage searchresultpage;

	@Given("User opens the Application")
	public void user_opens_the_application() {

	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String validproduct) {
		homepage = new HomePage();
		homepage.enterProductNameonSearchProductsField(validproduct);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		searchresultpage = homepage.clickOnSearchButton();

	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		Assert.assertTrue(searchresultpage.displayStatusOfValidProduct());
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproduct) {
		homepage = new HomePage();
		homepage.enterProductNameonSearchProductsField(invalidproduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.",
				searchresultpage.getMessageAboutNoProductMatching());
	}

	@When("User don't enter any product name into search box field")
	public void user_don_t_enter_any_product_name_into_search_box_field() {
		homepage = new HomePage();
		// Intentionally kept blank

	}

}
