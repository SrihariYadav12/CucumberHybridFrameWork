package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hooks.Myhooks;

public class SearchResultPage extends Myhooks {

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id ='button-search']/following-sibling::p")
	private WebElement messageaboutnoproductmatching;

	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;

	public boolean displayStatusOfValidProduct() {
		return validHPProduct.isDisplayed();
	}

	public String getMessageAboutNoProductMatching() {
		return messageaboutnoproductmatching.getText();
	}
}
