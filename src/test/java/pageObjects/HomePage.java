package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.Myhooks;

public class HomePage extends Myhooks {

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginoption;

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerOption;

	@FindBy(name = "search")
	private WebElement searchproductsfield;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchbutton;

	public void clickOnMyAccount() {
		myAccount.click();
	}

	public LoginPage selectLoginOption() {
		loginoption.click();
		return new LoginPage();
	}

	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage();
	}

	public void enterProductNameonSearchProductsField(String validProduct) {
		searchproductsfield.sendKeys(validProduct);

	}

	public SearchResultPage clickOnSearchButton() {
		searchbutton.click();
		return new SearchResultPage();
	}

}
