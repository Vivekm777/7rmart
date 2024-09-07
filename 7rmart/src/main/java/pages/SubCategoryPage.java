package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class SubCategoryPage {
	WebDriver driver;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@href,'list-sub-category') and contains(@class,'small')]")
	WebElement subcategoryMoreInfo;
	@FindBy(xpath = "(//span[@class='badge bg-success'])[1]")
	WebElement subcategoryActiveStatus;
	@FindBy(xpath = "(//span[text()='Inactive'])[1]")
	WebElement subcategoryInactiveStatus;
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	WebElement subcategoryStatusChangeAlert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement listofsubcategoryNewButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categorySelectDropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFileButton;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement subCategoryInformationSaveButton;
	@FindBy(xpath = "//div[contains(@class,'alert alert')]")
	WebElement subcategoryCreationAlert;

	public SubCategoryPage clickOnSubCategoryMoreInfo() {
		subcategoryMoreInfo.click();
		return this;
	}

	public SubCategoryPage clickonSubcategoryStatusButton() {
		if (subcategoryActiveStatus.isDisplayed()) {
			subcategoryActiveStatus.click();
		} 
		else {
			PageUtility pageutility = new PageUtility();
			pageutility.javaSriptClick(driver, subcategoryInactiveStatus);
			}
		return this;
	}

	public boolean isSubcategoryStatusChangeAlertDisplayed() {

		return subcategoryStatusChangeAlert.isDisplayed();
	}
	
	

	public SubCategoryPage clickonsubcategorymoreinfo() {
		subcategoryMoreInfo.click();
		return this;

	}

	public SubCategoryPage clickonlistofsubcategoryNewButton() {

		listofsubcategoryNewButton.click();
		return this;
	}

	public SubCategoryPage  selectcategoryFromDropdown() {
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownByVisibleText(categorySelectDropdown, "Electronics");
		return this;
	}

	public SubCategoryPage enterTextOnsubcategoryField(String subcategory) {
		subCategoryField.sendKeys(subcategory);
		return this;

	}

	public SubCategoryPage UploadImageUsingChooseFileButton() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFileButton, Constants.WRISTBANDIMAGE);
		return this;

	}

	public SubCategoryPage clickOnSubCategoryInformationSaveButton() {

		PageUtility pageUtility = new PageUtility();
		pageUtility.javaSriptClick(driver, subCategoryInformationSaveButton);
		return this;

	}

	public boolean isnewSubCategoryCreated() {

		return subcategoryCreationAlert.isDisplayed();
	}

}
