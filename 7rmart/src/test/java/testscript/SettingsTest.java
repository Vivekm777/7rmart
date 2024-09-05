package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Settings;
import utilities.ExcelUtility;

public class SettingsTest extends Base  {
@Test(retryAnalyzer = retry.Retry.class,description ="To verify whether user is able to manage the menu through setting button present in the homepage" )	
public void verifyUserIsAbleToManageMenu() throws IOException
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();	
	   Settings settings=new Settings(driver);
	   settings.clickOnSettingsButton();
	   settings.clickOnManageMenuButton();
	   settings.clickOnmenuManagementNewButton();
	   settings.enterTextOnMenuNameField(ExcelUtility.getStringData(1, 0, "settings"));
	   settings.selectParentMenuFromDropdown();
	   settings.clickonSaveButton();
	   boolean isUserAbleToCreateNewMenu=settings.isUserAbleToCreateNewMenu();
	   assertTrue(isUserAbleToCreateNewMenu, "User is unable to add new menu after clicking on new Button in menumanagement page");
	
	
}

}
