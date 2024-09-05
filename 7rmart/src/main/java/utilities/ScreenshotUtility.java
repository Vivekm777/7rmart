package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

		    public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
			TakesScreenshot screenshot = (TakesScreenshot) driver; //TakesScreenshot-interface
			File screenShot = screenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("DD_MM__YYYY_hh__mm__ss").format(new Date());
			File f1 = new File(System.getProperty("user.dir")+"//OutputScreenshot");
	        if(!f1.exists())
	        {
			 f1.mkdirs();
			 }
	       
			String destination = System.getProperty("user.dir")+"//OutputScreenshot//"+ failedTestCase +timestamp+".png";
			File finaldestination = new File(destination);
			FileHandler.copy(screenShot, finaldestination);
		
		      }
	
              }



















