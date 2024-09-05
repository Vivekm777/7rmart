package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
@Test(retryAnalyzer = retry.Retry.class,description = "To verify user is able to update the footertext  details in the FooterTextPage")
	public void verifyUserIsAbleToUpdateFooterText() throws IOException
	{
		   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
		   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		   LoginPage loginPage=new LoginPage(driver);
		   loginPage.enterUserNameOnUserField(userName);
		   loginPage.enterPasswordonPasswordField(password);
		   loginPage.clickOnSigInButton();	
		   ManageFooterTextPage footertextpage=new ManageFooterTextPage(driver);
		   footertextpage.clickOnManageFooterTextMoreInfo();
		   footertextpage.clickOnFooterTextActionButton();
		   footertextpage.clearTextOnfooterTextAddressField();
		   footertextpage.EnterTextOnfooterTextAddressField(ExcelUtility.getStringData(1, 0,"Manage FooterText Page"));
		   footertextpage.EnterTextOnFooterTextEmailField(ExcelUtility.getStringData(1, 1, "Manage FooterText Page"));
		   footertextpage.EnterTextOnFooterTextPhoneNumberField(ExcelUtility.getIntegerData(1, 2, "Manage FooterText Page"));
		   footertextpage.clickOnUpdateButton();
		   boolean isFooterTextUpdated=footertextpage.isFooterTextUpdated();
		   assertTrue(isFooterTextUpdated, "User is unable to update footer text after clicking on action button");
		
		
		
		
		
	}






















}
