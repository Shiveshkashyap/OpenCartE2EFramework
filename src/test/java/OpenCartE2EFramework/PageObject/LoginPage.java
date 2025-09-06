package OpenCartE2EFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement inputBox_username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputBox_password;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_login;


    public void EnterUserName(String username){
        inputBox_username.sendKeys(username);
    }
    public void EnterPassword(String pass){
        inputBox_password.sendKeys(pass);
    }
    public void ClickOnLoginBtn(){
        btn_login.click();
    }



}
