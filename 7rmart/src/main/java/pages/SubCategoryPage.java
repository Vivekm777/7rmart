package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubCategoryPage {
WebDriver driver;
public SubCategoryPage(WebDriver driver)
{
this.driver=driver;	
PageFactory.initElements(driver, this);	
}
@FindBy(xpath ="(//a[text()='More info '])[6]") WebElement subcategoryMoreInfo;
@FindBy(xpath = "(//span[@class='badge bg-success'])[1]") WebElement subcategoryActiveStatus;
@FindBy(xpath="(//span[text()='Inactive'])[1]") WebElement subcategoryInactiveStatus;
@FindBy(xpath = "//div[contains(@class,'alert alert')]") WebElement subcategoryStatusChangeAlert;

public void clickOnSubCategoryMoreInfo()
{
subcategoryMoreInfo.click();	
}


public void clickonSubcategoryStatusButton()
{
if(subcategoryInactiveStatus.isDisplayed()) 
{
subcategoryInactiveStatus.click();
} 
else
{
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click()",subcategoryActiveStatus);	
}
}


public boolean isSubcategoryStatusChangeAlertDisplayed()
{
	
return subcategoryStatusChangeAlert.isDisplayed();
}
}
