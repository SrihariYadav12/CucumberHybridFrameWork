package stepDefinitions;

import java.util.Map;

import org.testng.Assert;

import hooks.Myhooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utilities.Utilities;

public class RegisterTest extends Myhooks {
	private RegisterPage registerpage;
	private AccountPage accountpage;

	@Given("User navigates to the register page")
	public void user_navigates_to_the_register_page() {
		HomePage homepage = new HomePage();
		homepage.clickOnMyAccount();
		registerpage = homepage.selectRegisterOption();

	}

	@When("Enter below all mandatory details")
	public void enter_below_all_mandatory_details(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		registerpage.enterFirstName(dataMap.get("Firstname"));
		registerpage.enterLastName(dataMap.get("Lastname"));
		registerpage.enterFirstName(Utilities.generatEmail());
		registerpage.enterTelephoneNumber(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("Password"));
		registerpage.enterConfirmPassword(dataMap.get("Password"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerpage.selectprivacyPolicy();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		accountpage = registerpage.clickOncontinuebutton();
	}

	@Then("User account should create successfully")
	public void user_account_should_create_successfully() {
		Assert.assertEquals("Your Account Has Been Created!", accountpage.verifyNewUserRegisterMessage());

	}

	@Then("User should get prope warning about duplicate email")
	public void user_should_get_prope_warning_about_duplicate_email() {
		Assert.assertEquals("Warning: E-Mail Address is already registered!",
				registerpage.getDuplicatEmailWarningMessage());

	}

}
