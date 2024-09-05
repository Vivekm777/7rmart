package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

public void javaSriptClick(WebDriver  driver,WebElement element) 
{
   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("arguments[0].click();",element);
}


public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

public void dismissAlert(WebDriver driver)
{
	
	driver.switchTo().alert().dismiss();
}

public void selectDropdownByValue(WebElement element,String value)
{
	
Select obj=new Select(element);	
obj.selectByValue(value);
	
}

public void selectDropdownByVisibleText(WebElement element,String text)
{
	
Select obj=new Select(element);	
obj.selectByVisibleText(text);
	
}

public void selectDropdownByIndex(WebElement element,int index)
{
	
Select obj=new Select(element);	
obj.selectByIndex(index);
	
}

public void hoverOverAWebelement(WebDriver driver,WebElement element)
{
Actions action=new Actions(driver);
action.moveToElement(element).build().perform();
	
}

public void doubleClickOnWebElement(WebDriver driver,WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).doubleClick().build().perform();
	
}

public void rightClickOnWebElement(WebDriver driver,WebElement element)
{
	Actions action=new Actions(driver);
	action.moveToElement(element).contextClick().build().perform();
	
}

public void javaScriptExecutorScroll( WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,3000);"," ");
}


}
