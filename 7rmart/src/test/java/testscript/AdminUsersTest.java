package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify user is able to add new admin users in the adminuserspage")
	public void verifyUserIsAbleToAddAdminUsers() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String adminUsername = ExcelUtility.getStringData(1, 0, "Admin Users Page");
		String adminPassword = ExcelUtility.getStringData(1, 1, "Admin Users Page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName);
		loginPage.enterPasswordonPasswordField(password);
		loginPage.clickOnSigInButton();
		AdminUsersPage adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.clickOnAdminUsersMoreInfo().clickOnAdminUsersNewButton().enterTextOnadminUsersUserNameField(adminUsername).enterTextOnadminUsersPasswordField(adminPassword).selectUserTypeFromSelectDropdown().clickonSaveButtonUsingJavaScriptExecutor();
		// adminUsersPage.clickOnAdminUsersNewButton();
		// adminUsersPage.enterTextOnadminUsersUserNameField(adminUsername);
		// adminUsersPage.enterTextOnadminUsersPasswordField(adminPassword);
		// adminUsersPage.selectUserTypeFromSelectDropdown();
		// adminUsersPage.clickonSaveButtonUsingJavaScriptExecutor();
		boolean isAlertForUserCreationDisplayed = adminUsersPage.isAlertForUserCreationDisplayed();
		assertTrue(isAlertForUserCreationDisplayed, Constants.adminInvalidUsersUserCreationMessage);

	}

}
