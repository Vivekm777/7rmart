package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.Logout;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
@Test(description ="To verify user is able to logout of the application",groups={"smoke"})
public void verifyUserIsAbleToLogoutOfTheApplication() throws IOException
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();
	   Logout logout=new Logout(driver);
	   logout.clickOnAdminImage();
	   logout.clickOnLogOutButton();
	   boolean isSigInButtonDisplayed=logout.isSigInButtonDisplayed();
	   assertTrue(isSigInButtonDisplayed, "user is unable to logout of the application after clicking on logoutbutton");
	
}












}
