package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.SettingsPage;
import utilities.ExcelUtility;

public class SettingsTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify whether user is able to manage the menu through setting button present in the homepage")
	public void verifyUserIsAbleToManageMenu() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String menuName = ExcelUtility.getStringData(1, 0, "settings");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		SettingsPage settings = new SettingsPage(driver);
		settings.clickOnSettingsButton().clickOnManageMenuButton().clickOnmenuManagementNewButton().enterTextOnMenuNameField(menuName).selectParentMenuFromDropdown().clickonSaveButton();
		boolean isUserAbleToCreateNewMenu = settings.isUserAbleToCreateNewMenu();
		assertTrue(isUserAbleToCreateNewMenu,Constants.InvalidMenuCreationMessage);

	}

}
