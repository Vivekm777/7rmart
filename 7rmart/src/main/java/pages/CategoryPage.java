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
public CategoryPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}

@FindBy(xpath = "//a[contains(@href,'list-category') and contains(@class,'small')]") WebElement categoryMoreInfo;
@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement listCategoriesNewButton;
@FindBy(xpath = "//input[@id='category']") WebElement addcategoryCategoryField;
@FindBy(xpath="(//span[text()='discount'])[1]") WebElement selectGroupOption;
@FindBy(xpath = "//input[@id='main_img']") WebElement addcategoryChoseFileButton;
@FindBy(xpath="(//input[@value='yes'])[1]") WebElement showOnTopMenuRadioButton;
@FindBy(xpath="(//input[@value='yes'])[2]") WebElement showOnLeftMenuRadioButton;
@FindBy(xpath = "//button[text()='Save']") WebElement addCategorysaveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertForNewCategoryCreation;

public void clickOnCategoryMoreInfo()
{
categoryMoreInfo.click();	
	
}

public void clickonlistCategoriesNewButton()
{
listCategoriesNewButton.click();	
	
}

public void enterTextOnaddcategoryCategoryField(String category)
{
addcategoryCategoryField.sendKeys(category);	
	
}
public void clickOnselectGroupOption()
{

PageUtility pageutility=new PageUtility();
pageutility.javaSriptClick(driver, selectGroupOption);
}

public void uploadImageUsingaddcategoryChoseFileButton() throws AWTException
{
	FileUploadUtility fileuploadutility=new FileUploadUtility();
	fileuploadutility.fileUploadUsingSendKeys(addcategoryChoseFileButton, Constants.CHOCOLATEIMAGE);
	
}

public void clickOnshowOnTopMenuRadioButton()
{

	PageUtility pageutility=new PageUtility();
	pageutility.javaSriptClick(driver,showOnTopMenuRadioButton);	
}

public void clickOnshowOnLeftMenuRadioButton()
{

PageUtility pageutility=new PageUtility();
pageutility.javaSriptClick(driver,showOnLeftMenuRadioButton);
	
}

public void  clickOnAddCategorysaveButton()
{
	

PageUtility pageutility=new PageUtility();
pageutility.javaSriptClick(driver, addCategorysaveButton);

}

public boolean isAlertForNewCategoryCreationCreated()
{
	
return alertForNewCategoryCreation.isDisplayed();
}

}
