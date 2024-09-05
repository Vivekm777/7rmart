package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base{
@Test(retryAnalyzer = retry.Retry.class,description = "To verify whether user is able to change the status of the subcategory in the subcategory page")
public void ToverifyUserIsAbleToChangeSubcategoryStatus() throws IOException
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();	
       SubCategoryPage subcategorypage=new SubCategoryPage(driver);
       subcategorypage.clickOnSubCategoryMoreInfo();
       subcategorypage.clickonSubcategoryStatusButton();
       boolean isSubcategoryStatusChangeAlertDisplayed=subcategorypage.isSubcategoryStatusChangeAlertDisplayed();
       assertTrue(isSubcategoryStatusChangeAlertDisplayed, "User is unable to change subcategory status after clicking the status button");
}

@Test(description = "To verify whether user is able to add new subcategory in the subcategory page")
public void ToverifyUserIsAbleToAddNewSubCategory() throws IOException
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();	
       SubCategoryPage subcategorypage=new SubCategoryPage(driver);
       subcategorypage.clickonsubcategorymoreinfo();
       subcategorypage.clickonlistofsubcategoryNewButton();
       subcategorypage.selectcategoryFromDropdown();
       subcategorypage.enterTextOnsubcategoryField(ExcelUtility.getStringData(1, 0, "Sub Category page"));
       subcategorypage.UploadImageUsingChooseFileButton();
       subcategorypage.clickOnSubCategoryInformationSaveButton();
       boolean isnewSubCategoryCreated=subcategorypage.isnewSubCategoryCreated();
       assertTrue(isnewSubCategoryCreated, "User is unable to create new subcategory after clicking on new button present in the subcategory page");
	
	
}

}
