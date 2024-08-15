package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
WebDriver driver;
@BeforeTest
public void intialiseBrowser()
{
driver=new ChromeDriver();
driver.get("https://groceryapp.uniqassosiates.com/admin/login");	
driver.manage().window().maximize();	
	
}

@AfterTest
public void driverQuitAndClose()
{
	
driver.quit();	
	
}












}
