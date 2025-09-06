package OpenCartE2EFramework.TestCases;

import OpenCartE2EFramework.PageObject.AccountRegistrationPage;
import OpenCartE2EFramework.PageObject.HomePage;
import OpenCartE2EFramework.TestBase.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_AccountRegistrationTest extends BaseClass {
    @Test
    public void verify_account_registration() throws InterruptedException {
        logger.info("********Starting TC001_AccountRegistrationTest**********");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.ClickOnMyAccount();
            logger.info("Clicked on My Account Link.....");
            homePage.ClickOnRegister();
            logger.info("Clicked on My Register Link.....");
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            accountRegistrationPage.EnterFirstName(randomString());
            accountRegistrationPage.EnterLastName(randomString());
            logger.info("Name Entered.....");
            Thread.sleep(3000);
            accountRegistrationPage.EnterEmail(randomString() + "@gmail.com");
            accountRegistrationPage.EnterTelephone(randomNumeric());
            String password = randomAlphaNumeric();
            accountRegistrationPage.EnterPassword(password);
            accountRegistrationPage.EnterConfirmPassword(password);
            accountRegistrationPage.SelectPrivacyCheckBox();
            logger.info("All details entered.....");
            Thread.sleep(4000);
            accountRegistrationPage.ClickOnContinueButton();
            String confMsg = accountRegistrationPage.confirmMessage();
            Assert.assertEquals(confMsg, "Your Account Has Been Created!");
            logger.info("All good....");
        }catch (Exception e){
            logger.error("Test failed.....");
            logger.debug("Debug logs.....");
            Assert.fail();
        }
        logger.info("********Finished TC001_AccountRegistrationTest**********");

    }

}
