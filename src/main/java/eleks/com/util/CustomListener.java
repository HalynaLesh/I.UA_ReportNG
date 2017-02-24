package eleks.com.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import eleks.com.webdriver.WebDriverFactory;

public class CustomListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " started test");

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Success TestCase: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed TestCase: " + result.getName());
		System.setProperty("org.uncommons.reportng.escape-output", "false");  
		
		String screenshotPath = GetScreenShot.capture(WebDriverFactory.getInstance(), result.getName());
		Reporter.getCurrentTestResult();
		Reporter.log("<p><a href=\"file:///"+ screenshotPath + "\"><img src=\"file:///" + screenshotPath + "\" alt=\"\""+ "height='100' width='100'/> "+"<br />"); 
        Reporter.setCurrentTestResult(null);
					
		/*try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");	
			File source = ((TakesScreenshot) WebDriverFactory.getInstance()).getScreenshotAs(OutputType.FILE);
			String screenPath = System.getProperty("user.dir") + "\\ErrorScreenShots\\"+result.getName() + "_" +formater.format(calendar.getTime())+".png";
			FileUtils.copyFile(source, new File(screenPath)); 
			Reporter.log("<p><a href=\"file:///"+ screenPath + "\"><img src=\"file:///" + screenPath + "\" alt=\"\""+ "height='100' width='100'/> "+"<br />"); 
			
	            Reporter.setCurrentTestResult(null); 

	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }*/
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped TestCase: " + result.getName());
		System.setProperty("org.uncommons.reportng.escape-output", "false");  

		System.setProperty("org.uncommons.reportng.escape-output", "false");  
		
		String screenshotPath = GetScreenShot.capture(WebDriverFactory.getInstance(), result.getName());
		Reporter.getCurrentTestResult();
		Reporter.log("<p><a href=\"file:///"+ screenshotPath + "\"><img src=\"file:///" + screenshotPath + "\" alt=\"\""+ "height='100' width='100'/> "+"<br />"); 
        Reporter.setCurrentTestResult(null);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("FailedButWithinSuccessPercentage TestCase: " + result.getName());
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");  
		
		String screenshotPath = GetScreenShot.capture(WebDriverFactory.getInstance(), result.getName());
		Reporter.getCurrentTestResult();
		Reporter.log("<p><a href=\"file:///"+ screenshotPath + "\"><img src=\"file:///" + screenshotPath + "\" alt=\"\""+ "height='100' width='100'/> "+"<br />"); 
        Reporter.setCurrentTestResult(null);

	}

	public void onStart(ITestContext context) {
		System.out.println(context.getName() + " started test");

	}

	public void onFinish(ITestContext context) {
		System.out.println(context.getName() + " finished test");

	}

}
