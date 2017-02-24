package eleks.com.pages_tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eleks.com.pages.MailBoxPage;

public class MainPage_Test extends BasePage_Test {
	
	MailBoxPage mailBoxPage;
	
	@Test(priority = 0)
	public void isMainPageOpened_test() {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		Assert.assertTrue(mainPage.isMainPageOpened());
		Reporter.log("Checking is MainPage opened");
	}

	@Test(priority = 1)
	public void positive_loginAs_test() throws ClassNotFoundException,
			SQLException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		Assert.assertTrue(mailBoxPage.isMailBoxPageOpened());
		Reporter.log("Checking is MailBox Page opened");
		mailBoxPage.logout();
	}

	@Test(priority = 3)
	public void negative_loginAs_test() throws ClassNotFoundException,
			SQLException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs("gdgdg", "dgdfgd");
		Reporter.log("Login");
		Assert.assertTrue(mailBoxPage.isMailBoxPageOpened());
		Reporter.log("Checking is MailBox Page opened");
	}

}
