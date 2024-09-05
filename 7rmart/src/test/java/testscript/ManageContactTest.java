package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
@Test(retryAnalyzer = retry.Retry.class,description = "To verify user is able to update contact details in the ManageContactPage")
public void verifyUserisAbleToUpdateContactUsDetails() throws IOException
{
	   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
	   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.enterUserNameOnUserField(userName);
	   loginPage.enterPasswordonPasswordField(password);
	   loginPage.clickOnSigInButton();
	   ManageContactPage contactpage=new ManageContactPage(driver);
	   contactpage.clickOnManageContactMoreInfo();
	   contactpage.clickOnActionButton();
	   contactpage.clearTextOnPhoneNumberField();
	   contactpage.enterTextOnPhoneNumberField(ExcelUtility.getIntegerData(1, 0, "Manage Contact Page"));
	   contactpage.clearTextOnEmailField();
	   contactpage.enterTextOnEmailField(ExcelUtility.getStringData(1, 1, "Manage Contact Page"));
	   contactpage.clearTextonAddressField();
	   contactpage.enterTextonAddressField(ExcelUtility.getStringData(1, 2, "Manage Contact Page"));
	   contactpage.clearTextonDeliveryTimeField();
	   contactpage.enterTextonDeliveryTimeField(ExcelUtility.getStringData(1, 3, "Manage Contact Page"));
	   contactpage.clearTextonDeliveryChargeLimitField();
	   contactpage.enterTextonDeliveryChargeLimitField(ExcelUtility.getIntegerData(1, 4, "Manage Contact Page"));
	   contactpage.clickoncontactUsUpdateButtonUsingJavaScriptExecutor();
	   boolean isAlertForContactUsUpdationDisplayed=contactpage.isAlertForContactUsUpdationDisplayed();
	   assertTrue(isAlertForContactUsUpdationDisplayed,"User is unable to update contact us details through action button");
		
	}












}
