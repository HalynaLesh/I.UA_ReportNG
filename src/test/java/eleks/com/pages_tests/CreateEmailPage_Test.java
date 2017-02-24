package eleks.com.pages_tests;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import eleks.com.pages.CreateMailPage;
import eleks.com.pages.MailBoxPage;
import eleks.com.pages.SuccessSendMailPage;

public class CreateEmailPage_Test extends BasePage_Test {
	
	MailBoxPage mailBoxPage;
	CreateMailPage createMailPage;
	SuccessSendMailPage successSendMailPage;

	@Test
	public void createEmail_test()
			throws ClassNotFoundException, SQLException {
		mainPage.openMainPage();
		Reporter.log("Opening Main Page");
		mailBoxPage = mainPage.loginAs(getUserNameSQL(), getUserPassSQL());
		Reporter.log("Login");
		createMailPage = mailBoxPage.navigateToCreateEmailPage();
		Reporter.log("Navigating to Create Email Page");
		Assert.assertTrue(createMailPage.isCreateMailPageOpened());
		Reporter.log("Checking is Create Mail Page opened");
		successSendMailPage = createMailPage.createEmail(email.getTo(),
				email.getSubject(), email.getBody());
		Reporter.log("Create Email");
		Assert.assertTrue(successSendMailPage.isSuccessSendMailPageOpened());
		Reporter.log("Checking is Success Send Mail Page opened");
		mailBoxPage = successSendMailPage.goToMaiBoxPage();
		mailBoxPage.logout();
		Reporter.log("Logout");
	}

}
