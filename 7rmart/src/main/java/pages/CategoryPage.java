package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class CategoryPage {
	WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(@href,'list-category') and contains(@class,'small')]")
	WebElement categoryMoreInfo;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement listCategoriesNewButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement addcategoryCategoryField;
	@FindBy(xpath = "(//span[text()='discount'])[1]")
	WebElement selectGroupOption;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement addcategoryChoseFileButton;
	@FindBy(xpath = "(//input[@value='yes'])[1]")
	WebElement showOnTopMenuRadioButton;
	@FindBy(xpath = "(//input[@value='yes'])[2]")
	WebElement showOnLeftMenuRadioButton;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement addCategorysaveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertForNewCategoryCreation;

	public CategoryPage clickOnCategoryMoreInfo() {
		categoryMoreInfo.click();
		return this;

	}

	public CategoryPage clickonlistCategoriesNewButton() {
		listCategoriesNewButton.click();
		return this;
	}

	public CategoryPage enterTextOnaddcategoryCategoryField(String category) {
		addcategoryCategoryField.sendKeys(category);
		return this;
	}

	public CategoryPage clickOnselectGroupOption() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, selectGroupOption);
		return this;
	}

	public CategoryPage uploadImageUsingaddcategoryChoseFileButton() throws AWTException {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(addcategoryChoseFileButton, Constants.CHOCOLATEIMAGE);
		return this;
	}

	public CategoryPage clickOnshowOnTopMenuRadioButton() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, showOnTopMenuRadioButton);
		return this;
	}

	public CategoryPage clickOnshowOnLeftMenuRadioButton() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, showOnLeftMenuRadioButton);
		return this;

	}

	public CategoryPage clickOnAddCategorysaveButton() {

		PageUtility pageutility = new PageUtility();
		pageutility.javaSriptClick(driver, addCategorysaveButton);
		return this;
	}

	public boolean isAlertForNewCategoryCreationCreated() {

		return alertForNewCategoryCreation.isDisplayed();
	}

}
