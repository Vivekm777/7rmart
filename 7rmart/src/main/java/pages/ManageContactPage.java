package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@href,'list-contact') and contains(@class,'small')]")
	WebElement manageContactMoreInfo;
	@FindBy(xpath = "//a[contains(@class,'btn btn-sm')]/i")
	WebElement actionButton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phoneNumberField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTimeField;
	@FindBy(xpath = "//input[@id='del_limit']")
	WebElement deliveryChargeLimitField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement contactUpdateButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	WebElement contactUsUpdationAlert;

	public ManageContactPage clickOnManageContactMoreInfo() {
		manageContactMoreInfo.click();
		return this;

	}

	public ManageContactPage  clickOnActionButton() {
		actionButton.click();
		return this;
	}

	public ManageContactPage clearTextOnPhoneNumberField() {

		phoneNumberField.clear();
		return this;
	}

	public ManageContactPage enterTextOnPhoneNumberField(String phonenumber) {

		phoneNumberField.sendKeys(phonenumber);
		return this;
	}

	public ManageContactPage clearTextOnEmailField() {
		emailField.clear();
		return this;

	}

	public ManageContactPage enterTextOnEmailField(String email) {
		emailField.sendKeys(email);
		return this;

	}

	public ManageContactPage clearTextonAddressField() {

		addressField.clear();
		return this;
	}

	public ManageContactPage enterTextonAddressField(String address) {

		addressField.sendKeys(address);
		return this;
	}

	public ManageContactPage clearTextonDeliveryTimeField() {

		deliveryTimeField.clear();
		return this;
	}

	public ManageContactPage enterTextonDeliveryTimeField(String deliverytime) {

		deliveryTimeField.sendKeys(deliverytime);
		return this;
	}

	public ManageContactPage clearTextonDeliveryChargeLimitField() {
		deliveryChargeLimitField.clear();
		return this;

	}

	public ManageContactPage enterTextonDeliveryChargeLimitField(String deliverychargelimit) {
		deliveryChargeLimitField.sendKeys(deliverychargelimit);
		return this;

	}

	public ManageContactPage clickoncontactUsUpdateButtonUsingJavaScriptExecutor() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, contactUpdateButton);
		return this;
	}

	public boolean isAlertForContactUsUpdationDisplayed() {

		return contactUsUpdationAlert.isDisplayed();
	}

}
