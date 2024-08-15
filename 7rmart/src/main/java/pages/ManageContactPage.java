package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage
{

WebDriver driver;
public ManageContactPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
	
}
@FindBy(xpath = "(//a[@class='small-box-footer'])[9]") WebElement manageContactMoreInfo;
@FindBy(xpath ="//a[contains(@class,'btn btn-sm')]/i") WebElement actionButton;
@FindBy(xpath = "//input[@id='phone']") WebElement phoneNumberField;
@FindBy(xpath="//input[@id='email']") WebElement emailField;
@FindBy(xpath = "//textarea[@name='address']") WebElement addressField;
@FindBy(xpath = "//textarea[@name='del_time']") WebElement deliveryTimeField;
@FindBy(xpath = "//input[@id='del_limit']") WebElement deliveryChargeLimitField;
@FindBy(xpath = "//button[@type='submit']") WebElement contactUpdateButton;
@FindBy(xpath = "//div[contains(@class,'alert alert')]") WebElement contactUsUpdationAlert;

public void clickOnManageContactMoreInfo()
{
manageContactMoreInfo.click();
	
}

public void clickOnActionButton()
{
	actionButton.click();
}

public void enterTextOnPhoneNumberField(String phonenumber)
{
	
	phoneNumberField.sendKeys(phonenumber);
}


public void enterTextOnEmailField(String email)
{
	emailField.sendKeys(email);
	
}

public void enterTextonAddressField(String address)
{
	
	addressField.sendKeys(address);
}

public void enterTextonDeliveryTimeField(String deliverytime)
{
	
	deliveryTimeField.sendKeys(deliverytime);
}

public void enterTextonDeliveryChargeLimitField(String deliverychargelimit)
{
	deliveryChargeLimitField.sendKeys(deliverychargelimit);
	
}

public void clickoncontactUsUpdateButtonUsingJavaScriptExecutor()
{

	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()",contactUpdateButton);
	
}

public boolean isAlertForContactUsUpdationDisplayed()
{
	
	return contactUsUpdationAlert.isDisplayed();
}

}
