package OpenCartE2EFramework.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='content']/h2[1]")
    WebElement myAccountHeader;
    @FindBy(xpath = "//div[@class='list-group']//a[contains(text(),'Logout')]")
    WebElement btn_logout;
    public String confirmation(){
        String txt_AccountHeader= myAccountHeader.getText();
        return txt_AccountHeader;
    }
    public void clickOnLogout(){
        btn_logout.click();
    }
}
