package eleks.com.pages_tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eleks.com.pages.CreateMailPage;
import eleks.com.pages.MailBoxPage;
import eleks.com.pages.SuccessSendMailPage;

public class SuccessSendMailPage_Test extends BasePage_Test {
	
	MailBoxPage mailBoxPage;
	CreateMailPage createMailPage;
	SuccessSendMailPage successSendMailPage;

	@Test
	public void goToMailBoxPage_test() throws ClassNotFoundException, SQLException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		createMailPage = mailBoxPage.navigateToCreateEmailPage();
		Reporter.log("Navigating to Create Email Page");
		successSendMailPage = createMailPage.createEmail(email.getTo(),
				email.getSubject(), email.getBody());
		Reporter.log("Create Email");
		mailBoxPage = successSendMailPage.goToMaiBoxPage();
		Reporter.log("Navigating to MailBox Page");
		Assert.assertTrue(mailBoxPage.isMailBoxPageOpened());
		Reporter.log("Checking is MailBox Page opened");
		mailBoxPage.logout();
		Reporter.log("Logout");
	}

}
