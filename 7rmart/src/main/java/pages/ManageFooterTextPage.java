package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {
	WebDriver driver;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-footertext') and contains(@class,'small')] ")
	WebElement manageFooterTextMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'Footertext/edit?edit=1') and contains(@class,'btn btn-sm')]")
	WebElement footerTextActionButton;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement footerTextAddressField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement footerTextEmailField;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement footerTextPhoneNumberField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement footerTextUpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement footerTextUpdationAlert;

	public ManageFooterTextPage clickOnManageFooterTextMoreInfo() {
		manageFooterTextMoreInfo.click();
		return this;

	}

	public ManageFooterTextPage clickOnFooterTextActionButton() {
		footerTextActionButton.click();
		return this;
	}

	public ManageFooterTextPage clearTextOnfooterTextAddressField() {

		footerTextAddressField.clear();
		return this;
	}

	public ManageFooterTextPage EnterTextOnfooterTextAddressField(String address) {

		footerTextAddressField.sendKeys(address);
		return this;

	}

	public ManageFooterTextPage clearTextOnFooterTextEmailField() {

		footerTextEmailField.clear();
		return this;

	}

	public ManageFooterTextPage EnterTextOnFooterTextEmailField(String email) {

		footerTextEmailField.sendKeys(email);
		return this;

	}

	public ManageFooterTextPage clearTextOnFooterTextPhoneNumberField() {

		footerTextPhoneNumberField.clear();
		return this;

	}

	public ManageFooterTextPage EnterTextOnFooterTextPhoneNumberField(String email) {

		footerTextEmailField.sendKeys(email);
		return this;

	}

	public ManageFooterTextPage clickOnUpdateButton() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, footerTextUpdateButton);
		return this;

	}

	public boolean isFooterTextUpdated() {

		return footerTextUpdationAlert.isDisplayed();
	}

}
