package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(retryAnalyzer = retry.Retry.class, description = "To verify is user is able to login to the application", groups = {
			"Regression" })
	public void VerifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException {

		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		// loginPage.enterPasswordonPasswordField(password);
		// loginPage.clickOnSigInButton();
		boolean isHomepageDisplayed = loginPage.isHomePageLoaded();
		assertTrue(isHomepageDisplayed, Constants.InvalidLoginMessage);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "to verify user is unable to login to the application using Invalid username and valid password")
	public void VerifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		//loginPage.enterPasswordonPasswordField(password);
		//loginPage.clickOnSigInButton();
		boolean isAlertdisplayed = loginPage.isAlertMessageDisplayed();
		assertTrue(isAlertdisplayed, Constants.validLoginMessage);
	}

	@Test(retryAnalyzer = retry.Retry.class, description = "to verify user is unable to login to the application using valid username and Invalid password")
	public void VerifyTheUserIsAbleToLoginUsingvalidUsernameAndInvalidPassword() throws IOException {
		String userName = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		//loginPage.enterPasswordonPasswordField(password);
		//loginPage.clickOnSigInButton();
		boolean isAlertdisplayed = loginPage.isAlertMessageDisplayed();
		assertTrue(isAlertdisplayed,Constants.validloginMessage);

	}

	@Test(dataProvider = "loginprovider", retryAnalyzer = retry.Retry.class, description = "to verify user is unable to login to the application using Invalid username and Invalid password")
	public void VerifyTheUserIsAbleToLoginUsingInvalidUsernameAndInvalidPassword(String userName, String password)
			throws IOException {
		// String userName=ExcelUtility.getStringData(4, 0, "LoginPage");
		// String password=ExcelUtility.getStringData(4, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		//loginPage.enterPasswordonPasswordField(password);
		//loginPage.clickOnSigInButton();
		boolean isAlertdisplayed = loginPage.isAlertMessageDisplayed();
		assertTrue(isAlertdisplayed, Constants.validloginmessage);

	}

	@DataProvider(name = "loginprovider")
	public Object[][] getDataFromTestdata() throws IOException {

		return new Object[][] { {

				ExcelUtility.getStringData(4, 0, "LoginPage"), ExcelUtility.getStringData(4, 1, "LoginPage") }, };

	}

}
