package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
WebDriver driver;

public ManageNewsPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
	
}
@FindBy(xpath="(//i[@class=' fa fa-newspaper widget-stat-icon']//following::a)[1]") WebElement manageNewsMoreInfo;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement managenewsnew;
@FindBy(xpath="//textarea[@placeholder='Enter the news']") WebElement enterTheNewsTextField;
@FindBy(xpath="//button[text()='Save']") WebElement newsSaveButton;
@FindBy(xpath="//div[contains(@class,'alert alert')]") WebElement newsCreationAlert;


public void clickOnManageNewsMoreInfo()
{
	manageNewsMoreInfo.click();
}

public void clickOnManageNewsNew()
{
	managenewsnew.click();
}

public void enterTextOnEnterTheNewsTextField(String text)
{
	enterTheNewsTextField.sendKeys(text);	
}

public void clickOnSaveNewsButton()
{
	newsSaveButton.click();
}
public boolean isAlertForNewsCreationDisplayed()
{
	
	return newsCreationAlert.isDisplayed();
	
}
}
