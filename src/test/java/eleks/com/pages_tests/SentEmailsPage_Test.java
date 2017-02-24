package eleks.com.pages_tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eleks.com.pages.CreateMailPage;
import eleks.com.pages.MailBoxPage;
import eleks.com.pages.SentEmailsPage;
import eleks.com.pages.SuccessSendMailPage;

public class SentEmailsPage_Test extends BasePage_Test {
	
	MailBoxPage mailBoxPage;
	CreateMailPage createMailPage;
	SuccessSendMailPage successSendMailPage;
	SentEmailsPage sentEmailsPage;

/*	@BeforeMethod
	public void checkLogout() {
		if (mainPage.isLogoutPresent()) {
			mainPage.logout();
		}
	}*/

	@Test
	public void positive_verifySubject_test() throws ClassNotFoundException,
			SQLException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		createMailPage = mailBoxPage.navigateToCreateEmailPage();
		Reporter.log("Navigating to Create Email Page");
		successSendMailPage = createMailPage.createEmail(email.getTo(),
				email.getSubject(), email.getBody());
		Reporter.log("Create Email");
		sentEmailsPage = successSendMailPage.goToSentEmailsPage();
		Reporter.log("Navigating to Sent Emails Page");
		Assert.assertTrue(sentEmailsPage.isCorrectSubject(email.getSubject()));
		Reporter.log("Checking is correct subject");
		mailBoxPage = sentEmailsPage.navigateToMaiBoxPage();
		mailBoxPage.logout();
		Reporter.log("Logout");

	}

	@Test
	public void negative_verifySubject_test() throws ClassNotFoundException,
			SQLException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		createMailPage = mailBoxPage.navigateToCreateEmailPage();
		Reporter.log("Navigating to Create Email Page");
		successSendMailPage = createMailPage.createEmail(email.getTo(),
				email.getSubject(), email.getBody());
		Reporter.log("Create Email");
		sentEmailsPage = successSendMailPage.goToSentEmailsPage();
		Reporter.log("Navigating to Sent Emails Page");
		Assert.assertFalse(sentEmailsPage.isCorrectSubject("dgdfg"));
		Reporter.log("Checking is correct subject");
		mailBoxPage = sentEmailsPage.navigateToMaiBoxPage();
		mailBoxPage.logout();
		Reporter.log("Logout");

	}

	@Test
	public void positive_verifyBody_test() throws ClassNotFoundException,
			SQLException {
		mainPage.openMainPage();

		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());

		createMailPage = mailBoxPage.navigateToCreateEmailPage();

		successSendMailPage = createMailPage.createEmail(email.getTo(),
				email.getSubject(), email.getBody());

		sentEmailsPage = successSendMailPage.goToSentEmailsPage();
		sentEmailsPage.openSentEmail(email.getSubject());

		Assert.assertTrue(sentEmailsPage.isCorrectBodyOnEmail(email.getBody()));

		Assert.assertTrue(sentEmailsPage.isCorrectToOnEmail(email.getTo()));

		Assert.assertTrue(sentEmailsPage.isCorrectSubjectOnEmail(email
				.getSubject()));

		softAssert.assertAll();
		mailBoxPage = sentEmailsPage.navigateToMaiBoxPage();
		mailBoxPage.logout();

	}

	@Test
	public void negative_verifyBody_test() throws ClassNotFoundException,
			SQLException {
		mainPage.openMainPage();
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		createMailPage = mailBoxPage.navigateToCreateEmailPage();
		successSendMailPage = createMailPage.createEmail(email.getTo(),
				email.getSubject(), email.getBody());
		sentEmailsPage = successSendMailPage.goToSentEmailsPage();
		sentEmailsPage.openSentEmail(email.getSubject());
		Assert.assertFalse(sentEmailsPage.isCorrectBodyOnEmail(email.getBody()));
		Assert.assertFalse(sentEmailsPage.isCorrectToOnEmail(email.getTo()));
		Assert.assertFalse(sentEmailsPage.isCorrectSubjectOnEmail(email
				.getSubject()));
		softAssert.assertAll();
		mailBoxPage = sentEmailsPage.navigateToMaiBoxPage();
		mailBoxPage.logout();
	}

}
