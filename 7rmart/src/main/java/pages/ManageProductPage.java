package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-product') and contains(@class,'small')]")
	WebElement manageProductMoreInfo;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]/i")
	WebElement productDeleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement ProductDeletionAlert;

	public ManageProductPage clickOnManageProductMoreInfo() {
		manageProductMoreInfo.click();
		return this;

	}

	public  ManageProductPage clickOnProductDeletionButton() {
		productDeleteButton.click();
		return this;
	}

	public  ManageProductPage AcceptAlert() {

		PageUtility pageutility = new PageUtility();
		pageutility.acceptAlert(driver);
		return this;
	}

	public boolean isProductDeletionAlertDisplayed() {
		return ProductDeletionAlert.isDisplayed();
	}

}
