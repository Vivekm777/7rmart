package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	@Test(description = "To verify user is able to logout of the application", groups = { "smoke" })
	public void verifyUserIsAbleToLogoutOfTheApplication() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		LogoutPage logout = new LogoutPage(driver);
		logout.clickOnAdminImage().clickOnLogOutButton();
		boolean isSigInButtonDisplayed = logout.isSigInButtonDisplayed();
		assertTrue(isSigInButtonDisplayed,Constants.InvalidLogoutMessage);

	}

}
