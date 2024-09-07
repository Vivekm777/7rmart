package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-admin') and contains(@class,'small')]")
	WebElement adminUsersMoreInfo;
	@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-dange')]")
	WebElement adminUsersNewButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminUsersUserNameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminUsersPasswordField;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement adminUsersSelectDropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement adminUsersSaveButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	WebElement adminUsersUserCreationAlert;

	public AdminUsersPage clickOnAdminUsersMoreInfo() {
		adminUsersMoreInfo.click();
		return this;

	}

	public AdminUsersPage clickOnAdminUsersNewButton() {

		adminUsersNewButton.click();
		return this;
	}

	public AdminUsersPage enterTextOnadminUsersUserNameField(String username) {

		adminUsersUserNameField.sendKeys(username);
		return this;
		
	}

	public AdminUsersPage enterTextOnadminUsersPasswordField(String password) {
		adminUsersPasswordField.sendKeys(password);
		return this;
	}

	public AdminUsersPage selectUserTypeFromSelectDropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectDropdownByValue(adminUsersSelectDropdown, "staff");
		return this;

	}

	public AdminUsersPage clickonSaveButtonUsingJavaScriptExecutor() {
		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, adminUsersSaveButton);
		return this;
	}

	public boolean isAlertForUserCreationDisplayed() {

		return adminUsersUserCreationAlert.isDisplayed();
	}
}
