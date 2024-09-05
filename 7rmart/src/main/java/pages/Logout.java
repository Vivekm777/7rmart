package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
WebDriver driver;
public Logout(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements(driver, this);
	
}
@FindBy(xpath = "//img[contains(@src,'https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png')]") WebElement adminImage;
@FindBy(xpath = "(//a[@class='dropdown-item'])[2]") WebElement logoutButton;
@FindBy(xpath = "//button[text()='Sign In']") WebElement sigInButton;

public void clickOnAdminImage()
{
adminImage.click();	
	
}
public void clickOnLogOutButton()
{
 logoutButton.click();
}

public boolean isSigInButtonDisplayed()
{
	return sigInButton.isDisplayed();
}








}
