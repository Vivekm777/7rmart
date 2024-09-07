package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import constants.Constants;
import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	public Properties properties;
	FileInputStream fileinputstream;
	public ScreenshotUtility screenshot;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void intialiseBrowser(String browser) throws Exception {
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);

		} catch (Exception e) {
			e.printStackTrace();

		}
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		} else {
			throw new Exception("Incorrect Browser");
		}

		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshot = new ScreenshotUtility();
			screenshot.getScreenShot(driver, iTestResult.getName());

		}

		driver.quit();
	}

}
