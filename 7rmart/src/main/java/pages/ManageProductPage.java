package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageProductPage {
WebDriver driver;
public ManageProductPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

@FindBy(xpath="//a[contains(@href,'list-product') and contains(@class,'small')]") WebElement manageProductMoreInfo;
@FindBy(xpath="(//a[@class='btn btn-sm btn btn-danger btncss'])[1]/i") WebElement productDeleteButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement ProductDeletionAlert;


public void clickOnManageProductMoreInfo()
{
manageProductMoreInfo.click();	
	
}


public void clickOnProductDeletionButton()
{
productDeleteButton.click();	
}


public void AcceptAlert() 
{
	
PageUtility pageutility=new PageUtility();
pageutility.acceptAlert(driver);
}


public boolean isProductDeletionAlertDisplayed()
{
	return ProductDeletionAlert.isDisplayed();
}










}
