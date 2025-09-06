package OpenCartE2EFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//span[contains(text(),'My Account')]")
    WebElement lnk_MyAccount;
    @FindBy(xpath = "//*[contains(text(),'Register')]")
    WebElement lnk_register;
    @FindBy(xpath = "//*[contains(text(),'Login')]")
    WebElement lnk_login;

    public void ClickOnMyAccount(){
        lnk_MyAccount.click();
    }
    public void ClickOnRegister(){
        lnk_register.click();
    }
    public void ClickOnLogin(){lnk_login.click();}
}
