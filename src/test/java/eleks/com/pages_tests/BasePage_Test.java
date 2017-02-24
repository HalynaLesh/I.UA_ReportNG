package eleks.com.pages_tests;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import eleks.com.EmailBuilder.Email;
import eleks.com.EmailBuilder.EmailBuilder;
import eleks.com.pages.MainPage;
import eleks.com.sql.ConnectMySQL;
import eleks.com.util.Browser;
import eleks.com.util.ConfigProperties;
import eleks.com.webdriver.WebDriverFactory;

public class BasePage_Test {

	Email email = new EmailBuilder().buildTo("to@i.ua")
			.buildSubject("subject_tra_ta_ta").buildBody("body_tra_ta_ta")
			.build();

	ConnectMySQL mySQL = new ConnectMySQL();

	public Browser browser1 = new Browser();
	
	WebDriver webDriver;

	SoftAssert softAssert = new SoftAssert();

	MainPage mainPage;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setUp(String browser) throws Exception {
		webDriver = WebDriverFactory.getInstance(browser);
		browser1.setName(browser);
		mainPage = new MainPage(webDriver);
		webDriver.get(ConfigProperties.getProperties("url"));
		/*if (mainPage.isLogoutPresent()){
			mainPage.logout();
		}*/
	}
		
	@AfterMethod
	public void clearCookies(){
		webDriver.manage().deleteAllCookies();
	}
		
/*	@AfterTest
	public void writeDriver() throws IOException{
		FileWriter fw = new FileWriter(
				"src/main/resources/environment.properties", true);
		fw.write("Browser: " + browser1.getName() + "\n");
		fw.close();
	}*/

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		WebDriverFactory.killDriverInstance();
	}

	public String getUserNameSQL() throws SQLException, ClassNotFoundException {
		return mySQL.getUserNameSQL();
	}

	public String getUserPassSQL() throws SQLException, ClassNotFoundException {
		return mySQL.getUserPassSQL();
	}

}
