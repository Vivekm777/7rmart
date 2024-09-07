package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, description = "To verify user is able to update the footertext  details in the FooterTextPage")
	public void verifyUserIsAbleToUpdateFooterText() throws IOException {
		String userName = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");
		String address = ExcelUtility.getStringData(1, 0, "Manage FooterText Page");
		String email = ExcelUtility.getStringData(1, 1, "Manage FooterText Page");
		String phoneNumber = ExcelUtility.getIntegerData(1, 2, "Manage FooterText Page");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserField(userName);
		loginPage.enterPasswordonPasswordField(password);
		loginPage.clickOnSigInButton();
		ManageFooterTextPage footertextpage = new ManageFooterTextPage(driver);
		footertextpage.clickOnManageFooterTextMoreInfo().clickOnFooterTextActionButton().clearTextOnfooterTextAddressField().EnterTextOnfooterTextAddressField(address).EnterTextOnFooterTextEmailField(email).EnterTextOnFooterTextPhoneNumberField(phoneNumber).clickOnUpdateButton();
		// footertextpage.clickOnFooterTextActionButton();
		// footertextpage.clearTextOnfooterTextAddressField();
		// footertextpage.EnterTextOnfooterTextAddressField(address);
		// footertextpage.EnterTextOnFooterTextEmailField(email);
		// footertextpage.EnterTextOnFooterTextPhoneNumberField(phoneNumber);
		// footertextpage.clickOnUpdateButton();
		boolean isFooterTextUpdated = footertextpage.isFooterTextUpdated();
		assertTrue(isFooterTextUpdated, Constants.InvalidFooterTextUpdateMessage);

	}

}
