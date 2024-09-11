package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify whether user is able to change the status of the subcategory in the subcategory page")
	public void ToverifyUserIsAbleToChangeSubcategoryStatus() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickOnSubCategoryMoreInfo().clickonSubcategoryStatusButton();
		boolean isSubcategoryStatusChangeAlertDisplayed = subcategorypage.isSubcategoryStatusChangeAlertDisplayed();
		assertTrue(isSubcategoryStatusChangeAlertDisplayed,Constants.InvalidSubCategoryChangeOfStatusMessage);
	}

	@Test(description = "To verify whether user is able to add new subcategory in the subcategory page")
	public void ToverifyUserIsAbleToAddNewSubCategory() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String subCategory=ExcelUtility.getStringData(1, 0, "Sub Category page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.clickonsubcategorymoreinfo().clickonlistofsubcategoryNewButton().selectcategoryFromDropdown().enterTextOnsubcategoryField(subCategory).UploadImageUsingChooseFileButton().clickOnSubCategoryInformationSaveButton();
		boolean isnewSubCategoryCreated = subcategorypage.isnewSubCategoryCreated();
		assertTrue(isnewSubCategoryCreated,Constants.InvalidNewSubCategoryCreationMessage);

	}

}
