package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.Myhooks;

public class AccountPage extends Myhooks {

	public AccountPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Edit Account']")
	private WebElement editAccountOption;

	@FindBy(xpath = "//div[@id ='content']/h1")
	private WebElement newuserregistermessage;

	public boolean displayStatusOfEditAccountOption() {
		return editAccountOption.isDisplayed();
	}

	public String verifyNewUserRegisterMessage() {
		return newuserregistermessage.getText();
	}
}
