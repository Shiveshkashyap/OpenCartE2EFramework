package OpenCartE2EFramework.TestCases;

import OpenCartE2EFramework.PageObject.HomePage;
import OpenCartE2EFramework.PageObject.LoginPage;
import OpenCartE2EFramework.PageObject.MyAccountPage;
import OpenCartE2EFramework.TestBase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_LoginPageTest extends BaseClass {
@Test
    public void LoginTest(){
        logger.info("*****************Starting Login Test***********************");
        try {
            //Home Page
            HomePage homePage = new HomePage(driver);
            homePage.ClickOnMyAccount();
            homePage.ClickOnLogin();
//            Login Page
            LoginPage loginPage = new LoginPage(driver);
            loginPage.EnterUserName(p.getProperty("email"));
            loginPage.EnterPassword(p.getProperty("password"));
            loginPage.ClickOnLoginBtn();

//            MyAccount Page
            MyAccountPage accountPage = new MyAccountPage(driver);
            Assert.assertEquals(accountPage.confirmation(),p.getProperty("confirmationMessage"));
            accountPage.clickOnLogout();


        }catch (Exception e){
            logger.error("Test Failed....");
            logger.debug("Debug Logs....");
            Assert.fail();
        }
        logger.info("************Finished TC002_LoginPageTest********************");
    }

}
