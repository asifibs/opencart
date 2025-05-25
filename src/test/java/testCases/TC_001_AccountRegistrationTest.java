package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	@Test(groups= {"Regression","Master"}) //step 8 group added in testcase
	public void test_account_Registration() throws InterruptedException
	{
		logger.info("*** Starting TC_001_AccountRegistrationTest ***");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickRegister();
		logger.info("Clicked on registered link");		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		Thread.sleep(5000);
		
		String password=randomeAlphaNumberic();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
  		//regpage.setPassword("asif123");		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message");
		if(confmsg.equals("Your Account Has Beeon Create!!!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_001_AccountRegistrationTest***");
	}

}
