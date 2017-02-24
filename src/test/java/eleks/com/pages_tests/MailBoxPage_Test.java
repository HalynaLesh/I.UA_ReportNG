package eleks.com.pages_tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eleks.com.pages.CreateMailPage;
import eleks.com.pages.MailBoxPage;

public class MailBoxPage_Test extends BasePage_Test {
	
	MailBoxPage mailBoxPage;
	CreateMailPage createMailPage;

	@Test
	public void goToCreateEmailPage_test() throws SQLException, ClassNotFoundException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		createMailPage = mailBoxPage.navigateToCreateEmailPage();
		Reporter.log("Navigating to Create Email Page");
		Assert.assertTrue(createMailPage.isCreateMailPageOpened());
		Reporter.log("Checking is Create Mail Page opened");
		mailBoxPage = createMailPage.navigateToMailBoxPage();
		mailBoxPage.logout();
		Reporter.log("Logout");
	}

	@Test
	public void logout_test() throws SQLException, ClassNotFoundException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		mainPage = mailBoxPage.logout();
		Reporter.log("Logout");
		Assert.assertTrue(mainPage.isMainPageOpened());
		Reporter.log("Checking is Mail Page opened");
		
	}

}
