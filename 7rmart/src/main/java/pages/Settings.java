package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Settings {
	WebDriver driver;

	public Settings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[contains(text(),'Set')]")
	WebElement settingsbutton;
	@FindBy(xpath = "//p[contains(text(),'Manage Menu')]")
	WebElement ManagemenuButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement menuManagementNewButton;
	@FindBy(xpath = "//input[@id='name']")
	WebElement menuNameField;
	@FindBy(xpath = "//select[@id='menu_id']")
	WebElement parentmenuSelectDropdown;
	@FindBy(xpath = "//button[@name='create']")
	WebElement menuManagementSaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement menuCreationAlert;

	public Settings clickOnSettingsButton() {
		settingsbutton.click();
        return this;
	}

	public Settings clickOnManageMenuButton() {

		ManagemenuButton.click();
		 return this;
	}

	public Settings clickOnmenuManagementNewButton() {

		menuManagementNewButton.click();
		 return this;
	}

	public Settings enterTextOnMenuNameField(String menuname) {
		menuNameField.sendKeys(menuname);
		 return this;

	}

	public Settings selectParentMenuFromDropdown() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectDropdownByVisibleText(parentmenuSelectDropdown, "Dashboard");
		 return this;

	}

	public Settings clickonSaveButton() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, menuManagementSaveButton);
		 return this;

	}

	public boolean isUserAbleToCreateNewMenu() {

		return menuCreationAlert.isDisplayed();
	}
}
