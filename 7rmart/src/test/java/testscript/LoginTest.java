package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test
  public void VerifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
  {
   //String userName="admin";
   //String password="admin";
   String userName=ExcelUtility.getStringData(1, 0, "LoginPage");
   String password=ExcelUtility.getStringData(1, 1, "LoginPage");
   LoginPage loginPage=new LoginPage(driver);
   loginPage.enterUserNameOnUserField(userName);
   loginPage.enterPasswordonPasswordField(password);
   loginPage.clickOnSigInButton();
   boolean isHomepageDisplayed=loginPage.isHomePageLoaded();
   assertTrue(isHomepageDisplayed, "HomePage is not loaded when user is enter valid credentials ");
	}
	
	@Test
	public void VerifyTheUserIsAbleToLoginUsingInvalidUsernameAndValidPassword() throws IOException
	{
	String userName=ExcelUtility.getStringData(2, 0, "LoginPage");
	String password=ExcelUtility.getStringData(2, 1,"LoginPage" );
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUserNameOnUserField(userName);
	loginPage.enterPasswordonPasswordField(password);
	loginPage.clickOnSigInButton();
	boolean isAlertdisplayed=loginPage.isAlertMessageDisplayed();
	assertTrue(isAlertdisplayed, "Homepage  is loaded when user enter validusername and Invalid password");
	}
	
	
	@Test
	public void VerifyTheUserIsAbleToLoginUsingvalidUsernameAndInalidPassword() throws IOException
	{
	String userName=ExcelUtility.getStringData(3, 0, "LoginPage");
	String password=ExcelUtility.getStringData(3, 1,"LoginPage" );
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUserNameOnUserField(userName);
	loginPage.enterPasswordonPasswordField(password);
	loginPage.clickOnSigInButton();
	boolean isAlertdisplayed=loginPage.isAlertMessageDisplayed();
	assertTrue(isAlertdisplayed, "Homepage  is loaded when user enter Invalid username and valid password");
		
	}
	
	@Test
	public void VerifyTheUserIsAbleToLoginUsingInvalidUsernameAndInalidPassword() throws IOException
	{
	String userName=ExcelUtility.getStringData(4, 0, "LoginPage");
	String password=ExcelUtility.getStringData(4, 1, "LoginPage");
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUserNameOnUserField(userName);
	loginPage.enterPasswordonPasswordField(password);
	loginPage.clickOnSigInButton();
	boolean isAlertdisplayed=loginPage.isAlertMessageDisplayed();
	assertTrue(isAlertdisplayed, "Homepage  is loaded when user enter Invalid username and Invalid password");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
