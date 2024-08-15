package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
WebDriver driver;

public AdminUsersPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
}

@FindBy(xpath = "(//a[text()='More info '])[1]") WebElement adminUsersMoreInfo;
@FindBy(xpath = "//a[contains(@class,'btn btn-rounded btn-dange')]") WebElement adminUsersNewButton;
@FindBy(xpath = "//input[@id='username']") WebElement adminUsersUserNameField;
@FindBy(xpath = "//input[@id='password']") WebElement adminUsersPasswordField;
@FindBy(xpath = "//select[@id='user_type']") WebElement adminUsersSelectDropdown;
@FindBy(xpath = "//button[@name='Create']") WebElement adminUsersSaveButton;
@FindBy(xpath = "//div[contains(@class,'alert alert')]") WebElement adminUsersUserCreationAlert;


public void clickOnAdminUsersMoreInfo()
{
	adminUsersMoreInfo.click();
	
}

public void clickOnAdminUsersNewButton()
{
	
adminUsersNewButton.click();
}


public void enterTextOnadminUsersUserNameField(String username)
{
	
	adminUsersUserNameField.sendKeys(username);
}

public void enterTextOnadminUsersPasswordField(String password)
{
	adminUsersPasswordField.sendKeys(password);
}

public void selectUserTypeFromSelectDropdown(String value)
{
	Select obj=new Select(adminUsersSelectDropdown);
	obj.selectByValue(value);
	
}
public void clickonSaveButtonUsingJavaScriptExecutor()
{
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()",adminUsersSaveButton);
}

public boolean isAlertForUserCreationDisplayed()
{
	
	return adminUsersUserCreationAlert.isDisplayed();
}
}
