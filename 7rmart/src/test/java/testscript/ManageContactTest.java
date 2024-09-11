package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify user is able to update contact details in the ManageContactPage")
	public void verifyUserisAbleToUpdateContactUsDetails() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String phoneNumber=ExcelUtility.getIntegerData(1, 0, "Manage Contact Page");
		String email=ExcelUtility.getStringData(1, 1, "Manage Contact Page");
		String address=ExcelUtility.getStringData(1, 2, "Manage Contact Page");
		String deliveryTime=ExcelUtility.getStringData(1, 3, "Manage Contact Page");
		String deliverychargelimit=ExcelUtility.getIntegerData(1, 4, "Manage Contact Page");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName).enterPasswordonPasswordField(password).clickOnSigInButton();
		ManageContactPage contactpage = new ManageContactPage(driver);
		contactpage.clickOnManageContactMoreInfo().clickOnActionButton().clearTextOnPhoneNumberField().enterTextOnPhoneNumberField(phoneNumber).clearTextOnEmailField().enterTextOnEmailField(email).clearTextonAddressField().enterTextonAddressField(address).clearTextonDeliveryTimeField().enterTextonDeliveryTimeField(deliveryTime).clearTextonDeliveryChargeLimitField().enterTextonDeliveryChargeLimitField(deliverychargelimit).clickoncontactUsUpdateButton();
        boolean isAlertForContactUsUpdationDisplayed = contactpage.isAlertForContactUsUpdationDisplayed();
		assertTrue(isAlertForContactUsUpdationDisplayed,Constants.InvalidContactUpdateMessage);

	}

}
