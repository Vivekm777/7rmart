package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends Base {
@Test(retryAnalyzer = retry.Retry.class,description = "To verify user is able to create new category in the category page")
public void verifyUserIsAbleToAddNewCategory() throws IOException, AWTException, InterruptedException 
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();	
	   CategoryPage categorypage=new CategoryPage(driver);
	   categorypage.clickOnCategoryMoreInfo();
	   categorypage.clickonlistCategoriesNewButton();
	   categorypage.enterTextOnaddcategoryCategoryField(ExcelUtility.getStringData(1, 0,"Category Page"));
	   categorypage.clickOnselectGroupOption();
	   categorypage.uploadImageUsingaddcategoryChoseFileButton();
	   categorypage.clickOnshowOnTopMenuRadioButton();
	   categorypage.clickOnshowOnLeftMenuRadioButton();
	   categorypage.clickOnAddCategorysaveButton();
	   boolean isAlertForNewCategoryCreationCreated =categorypage.isAlertForNewCategoryCreationCreated();
	   assertTrue(isAlertForNewCategoryCreationCreated, "User is unable to add new category using new category button");
	   
	
}
	
	
	
	
	
	
	
	
	

}
