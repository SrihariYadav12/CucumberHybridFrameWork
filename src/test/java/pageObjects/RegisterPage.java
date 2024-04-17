package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.Myhooks;

public class RegisterPage extends Myhooks {

	public RegisterPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-firstname")
	private WebElement firstnameField;

	@FindBy(id = "input-lastname")
	private WebElement lastnameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement privacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continuebutton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicatemailwarningmessage;

	public void enterFirstName(String firstname) {
		firstnameField.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastnameField.sendKeys(lastname);
	}

	public void enterEmail(String newemail) {
		emailField.sendKeys(newemail);
	}

	public void enterTelephoneNumber(String telephone) {
		telephoneField.sendKeys(telephone);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmpassword) {
		confirmPasswordField.sendKeys(confirmpassword);
	}

	public void selectprivacyPolicy() {
		privacyPolicy.click();
	}

	public AccountPage clickOncontinuebutton() {
		continuebutton.click();
		return new AccountPage();
	}

	public String getDuplicatEmailWarningMessage() {
		return duplicatemailwarningmessage.getText();
	}

}
