package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProductPage {
WebDriver driver;
public ManageProductPage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver,this);
}

@FindBy(xpath="(//a[text()='More info '])[7]") WebElement manageProductMoreInfo;
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
	
driver.switchTo().alert().accept();	
}

public boolean isProductDeletionAlertDisplayed()
{
	
	return ProductDeletionAlert.isDisplayed();
}










}
