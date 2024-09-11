 package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.CategoryPage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

    public class CategoryTest extends Base {
	public CategoryPage category;
	public AdminUsersPage admin;
	public LoginPage login;	
	
	
      @Test(retryAnalyzer = retry.Retry.class,description = "To verify user is able to create new category in the category page")
       public void verifyUserIsAbleToAddNewCategory() throws IOException, AWTException, InterruptedException {
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   String categoryname=ExcelUtility.getStringData(1, 0,"Category Page");
	   LoginPage login=new LoginPage(driver);
	   login.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
	   CategoryPage categorypage=new CategoryPage(driver);
	   categorypage.clickOnCategoryMoreInfo().clickonlistCategoriesNewButton().enterTextOnaddcategoryCategoryField(categoryname).clickOnselectGroupOption().uploadImageUsingaddcategoryChoseFileButton().clickOnTopMenuRadioButton().clickOnLeftMenuRadioButton().clickOnAddCategorysaveButton();
	   boolean isAlertForNewCategoryCreationCreated =categorypage.isAlertForNewCategoryCreationCreated();
	   assertTrue(isAlertForNewCategoryCreationCreated,Constants.InvalidCategoryCreationMessage);
	   
	
}


	
	
	
	
	
	
	
	
	

}
