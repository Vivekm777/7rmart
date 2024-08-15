package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@placeholder='Username']") WebElement usernameField;
@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordField;
@FindBy(xpath ="//button[text()='Sign In']") WebElement siginButton; 
@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
@FindBy(xpath="//div[contains(@class,'alert alert')]") WebElement AlertForInvalidLogin;

public void enterUserNameOnUserField(String userName)
{
	usernameField.sendKeys(userName);
	
}

public void enterPasswordonPasswordField(String password)
{
	
	passwordField.sendKeys(password);	
}

public void clickOnSigInButton()
{
	siginButton.click();
	
}

public boolean isHomePageLoaded()
{
	return dashboard.isDisplayed();
	
}

public boolean isAlertMessageDisplayed()
{
	
return AlertForInvalidLogin.isDisplayed();
}

}
