package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement siginButton;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//a[contains(@href,'list-category') and contains(@class,'small')]")
	WebElement categoryMoreInfo;
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	WebElement AlertForInvalidLogin;

	public LoginPage enterUserNameOnUserField(String userName) {
		usernameField.sendKeys(userName);
		return this;

	}

	public LoginPage enterPasswordonPasswordField(String password) {

		passwordField.sendKeys(password);
		return this;
	}

	public AdminUsersPage clickOnSigInButton() {
		siginButton.click();
		return new AdminUsersPage(driver);

	}
	

	public boolean isHomePageLoaded() {
		return dashboard.isDisplayed();

	}

	public boolean isAlertMessageDisplayed() {

		return AlertForInvalidLogin.isDisplayed();
	}

}
