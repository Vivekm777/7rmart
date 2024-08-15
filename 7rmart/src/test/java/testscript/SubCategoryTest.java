package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base{
@Test
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



}
