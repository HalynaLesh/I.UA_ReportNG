package eleks.com.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import eleks.com.webdriver.WebDriverFactory;

public class GetScreenShot {
	
	public static String capture(WebDriver driver, String screenshotName) 
    {
        /*TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;*/
		
	/*	try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String screenPath = "./ErrorScreenShots/"+screenshotName + "_" +formater.format(calendar.getTime())+".png";	
		//	String screenPath = System.getProperty("user.dir") + "ExtentReport\\ErrorScreenshots\\"+screenshotName+".png";	
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}*/
		
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");	
			File source = ((TakesScreenshot) WebDriverFactory.getInstance()).getScreenshotAs(OutputType.FILE);
			String screenPath = System.getProperty("user.dir") + "\\ErrorScreenShots\\"+ screenshotName + "_" +formater.format(calendar.getTime())+".png";
			FileUtils.copyFile(source, new File(screenPath)); 
/*			Reporter.log("<p><a href=\"file:///"+ screenPath + "\"><img src=\"file:///" + screenPath + "\" alt=\"\""+ "height='100' width='100'/> "+"<br />"); 
			
	            Reporter.setCurrentTestResult(null); */
			return screenPath;
	        } catch (IOException e) {
	        	System.out.println("Exception while taking screenshot: " + e.getMessage());
				return e.getMessage();
	        }
    }

}
