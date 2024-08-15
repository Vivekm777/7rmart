package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
@Test
public void verifyUserIsAbleToDeleteProduct() throws IOException
{
String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
String password=ExcelUtility.getStringData(1, 1, "LoginPage");
LoginPage loginPage=new LoginPage(driver);
loginPage.enterUserNameOnUserField(userName);
loginPage.enterPasswordonPasswordField(password);
loginPage.clickOnSigInButton();
ManageProductPage manageproduct=new ManageProductPage(driver);
manageproduct.clickOnManageProductMoreInfo();
manageproduct.clickOnProductDeletionButton();
manageproduct.AcceptAlert();
boolean isProductDeletionAlertDisplayed=manageproduct.isProductDeletionAlertDisplayed();
assertTrue(isProductDeletionAlertDisplayed,"User is unable to delete product after clicking on the product delete button");
	
	






}
















}
