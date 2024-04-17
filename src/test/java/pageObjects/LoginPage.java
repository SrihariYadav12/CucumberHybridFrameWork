package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.Myhooks;

public class LoginPage extends Myhooks {

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailfield;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;

	public void enterEmail(String email) {
		emailfield.sendKeys(email);

	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public AccountPage clickOnLoginButton() {
		loginButton.click();

		return new AccountPage();
	}

	public String getWarningMessageText() {
		return warningMessage.getText();
	}

}
