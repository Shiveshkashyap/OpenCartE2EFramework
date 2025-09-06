package OpenCartE2EFramework.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountRegistrationPage extends BasePage{

    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement Header_RegistrationPage;
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txt_FirstName;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txt_LastName;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txt_Email;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement txt_Telephone;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txt_Password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txt_ConfirmPassword;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement chkBox_privacy;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement btn_Continue;

    @FindBy(xpath = "//div[@class='col-sm-9']/h1")
    WebElement ConfirmRegistration;


    public void ValidatesRegistrationPageHeader(){
      String header=  wait.until(ExpectedConditions.visibilityOfElementLocated((By) Header_RegistrationPage)).getText();
      if (header.equals("Register Account")){
          assert true;
      }else
          assert false;
    }
    public void EnterFirstName(String firstName){
        txt_FirstName.sendKeys(firstName);
    }
    public void EnterLastName(String lastName){
        txt_LastName.sendKeys(lastName);
    }
    public void EnterEmail(String email){
//        String randomCharacter = RandomStringUtils.randomAlphabetic(5);
//        System.out.println(randomCharacter);
//        String email = randomString()+"@gmail.com";
//        txt_Email.sendKeys(randomCharacter+"@gmail.com");
        txt_Email.sendKeys(email);
        System.out.println("Email : "+email);
    }
    public void EnterTelephone(String telephone){
       txt_Telephone.sendKeys(telephone);
    }
    public void EnterPassword(String Password){
        txt_Password.sendKeys(Password);
    }
    public void EnterConfirmPassword(String ConfirmPassword){
        txt_ConfirmPassword.sendKeys(ConfirmPassword);
    }
    public void SelectPrivacyCheckBox(){
        chkBox_privacy.click();
    }
    public void ClickOnContinueButton(){
        btn_Continue.click();
    }
    public String confirmMessage(){
        try {
            return (ConfirmRegistration.getText());
        }catch (Exception e) {
            return (e.getMessage());
        }}

}
