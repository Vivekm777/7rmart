package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//img[contains(@src,'https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png')]")
	WebElement adminImage;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	WebElement logoutButton;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement sigInButton;

	public LogoutPage clickOnAdminImage() {
		adminImage.click();
		return this;

	}

	public LogoutPage clickOnLogOutButton() {
		logoutButton.click();
		return this;

	}

	public boolean isSigInButtonDisplayed() {
		return sigInButton.isDisplayed();
	}

}
