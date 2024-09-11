 package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	public AdminUsersPage admin;
	public LoginPage login;
	public CategoryPage category;
	
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify user is able to add new admin users in the adminuserspage")
	public void verifyUserIsAbleToAddAdminUsers() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String adminUsername = ExcelUtility.getStringData(1, 0, "Admin Users Page");
		String adminPassword = ExcelUtility.getStringData(1, 1, "Admin Users Page");
	    login = new LoginPage(driver);
	    admin=login.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
	    category=admin.clickOnAdminUsersMoreInfo().clickOnAdminUsersNewButton().enterTextOnadminUsersUserNameField(adminUsername).enterTextOnadminUsersPasswordField(adminPassword).selectUserTypeFromSelectDropdown().clickonSaveButtonUsingJavaScriptExecutor();
		//login.enterUserNameOnUserField(userName);
		//login.enterPasswordonPasswordField(password);
		//login.clickOnSigInButton();
		//AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		//adminUsersPage.clickOnAdminUsersMoreInfo();
	    // adminUsersPage.clickOnAdminUsersNewButton();
		// adminUsersPage.enterTextOnadminUsersUserNameField(adminUsername);
		// adminUsersPage.enterTextOnadminUsersPasswordField(adminPassword);
		// adminUsersPage.selectUserTypeFromSelectDropdown();
		// adminUsersPage.clickonSaveButtonUsingJavaScriptExecutor();
		boolean isAlertForUserCreationDisplayed = admin.isAlertForUserCreationDisplayed();
		assertTrue(isAlertForUserCreationDisplayed, Constants.adminInvalidUsersUserCreationMessage);

	}

}
