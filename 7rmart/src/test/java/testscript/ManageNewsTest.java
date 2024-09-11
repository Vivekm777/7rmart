package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify user is able to add new news in the ManageNewsPage")
	public void verifyUserIsAbleToAddNews() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String news=ExcelUtility.getStringData(1, 0, "Manage news page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnManageNewsMoreInfo().clickOnManageNewsNew().enterTextOnEnterTheNewsTextField(news).clickOnSaveNewsButton();
		boolean isAletForNewscreationDisplayed = managenews.isAlertForNewsCreationDisplayed();
		assertTrue(isAletForNewscreationDisplayed,Constants.InvalidNewsCreationMessage);

	}

}
