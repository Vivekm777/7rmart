package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base
{
@Test(retryAnalyzer = retry.Retry.class,description = "To verify user is able to add new admin users in the adminuserspage")	
public void verifyUserIsAbleToAddAdminUsers() throws IOException
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();
       AdminUsersPage adminUsersPage=new AdminUsersPage(driver);
       adminUsersPage.clickOnAdminUsersMoreInfo();
       adminUsersPage.clickOnAdminUsersNewButton();
       adminUsersPage.enterTextOnadminUsersUserNameField(ExcelUtility.getStringData(1, 0, "Admin Users Page"));
       adminUsersPage.enterTextOnadminUsersPasswordField(ExcelUtility.getStringData(1, 1, "Admin Users Page"));
       adminUsersPage.selectUserTypeFromSelectDropdown();
       adminUsersPage.clickonSaveButtonUsingJavaScriptExecutor();
       boolean isAlertForUserCreationDisplayed=adminUsersPage.isAlertForUserCreationDisplayed();
       assertTrue(isAlertForUserCreationDisplayed, "User is unable to create newuser after clicking on new button in the admin Users page");
       

}












}
