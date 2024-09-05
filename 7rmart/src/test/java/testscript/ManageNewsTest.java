package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	@Test(retryAnalyzer = retry.Retry.class,description = "To verify user is able to add new news in the ManageNewsPage")
	public void verifyUserIsAbleToAddNews() throws IOException
	{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();
	   ManageNewsPage managenews=new ManageNewsPage(driver);
       managenews.clickOnManageNewsMoreInfo();
       managenews.clickOnManageNewsNew();
       managenews.enterTextOnEnterTheNewsTextField(ExcelUtility.getStringData(1, 0, "Manage news page"));
       managenews.clickOnSaveNewsButton();
       boolean isAletForNewscreationDisplayed=managenews.isAlertForNewsCreationDisplayed();
       assertTrue(isAletForNewscreationDisplayed, "User is unable to add news using add news button");
       

	}







}
