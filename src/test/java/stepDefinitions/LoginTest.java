package stepDefinitions;

import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import hooks.Myhooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ConfigReader;
import utilities.Utilities;

public class LoginTest extends Myhooks {
	private LoginPage loginpage;
	private AccountPage accountpage;

	@Before
	public void setUp() {
		Properties prop = ConfigReader.intilizeProperties();
		Myhooks.intilizeBrowser(prop.getProperty("browser"));

	}

	@After
	public void tearDown(Scenario scenario) {
		String ScenarioName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			byte[] srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenshot, "image/png", ScenarioName);
		}
		driver.quit();
	}

	@Given("User navigate to login page")
	public void user_navigate_to_login_page() {
		HomePage homepage = new HomePage();
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String email) {
		loginpage.enterEmail(email);
	}

	@When("^User enters valid password (.+) into password field$")
	public void User_enters_valid_password_into_password_field(String password) {
		loginpage.enterPassword(password);
	}

	@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String email) {
		loginpage.enterEmail(email);
	}

	public void user_enters_valid_password_into_password_field(String password) {
		loginpage.enterPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		accountpage = loginpage.clickOnLoginButton();
	}

	@Then("Login successful page should be visible")
	public void login_successful_page_should_be_visible() {
		Assert.assertTrue(accountpage.displayStatusOfEditAccountOption());
	}

	@When("User enters Invalid email and Invalid password {string}")
	public void user_enters_invalid_email_and_invalid_password_username_password(String invalidpassword) {
		loginpage.enterEmail(Utilities.generatEmail());
		loginpage.enterPassword(invalidpassword);
	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch() {
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", loginpage.getWarningMessageText());
	}

	@When("User enters Invalid email and valid password {string}")
	public void user_enters_invalid_email_and_valid_password_username_password(String password) {
		loginpage.enterEmail(Utilities.generatEmail());
		loginpage.enterPassword(password);
	}

	@When("User enters don't enter email address into email field")
	public void user_enters_don_t_enter_email_address_into_email_field() {
		loginpage.enterEmail("");

	}

	@When("User enters don't enter password address into password field")
	public void user_enters_don_t_enter_password_address_into_password_field() {
		loginpage.enterPassword("");

	}

}
