package OpenCartE2EFramework.TestBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os ,String browser) throws IOException {
//        Loading config.properties file

        FileReader file =new FileReader("./src/test/resources/config.properties");
        p=new Properties();
        p.load(file);
        logger = LogManager.getLogger(this.getClass());// to get log

        switch (browser.toLowerCase()){
            case "chrome" : driver = new ChromeDriver();break;
            case "edge" : driver = new EdgeDriver();break;
            case "firefox" : driver = new FirefoxDriver();break;
            default:
                System.out.println("Invalid Browser Name ......");return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public String randomString() {
        String random = RandomStringUtils.randomAlphabetic(5);
        return random;
    }

    public String randomNumeric() {
        String randomNumber = RandomStringUtils.randomNumeric(10);
        return randomNumber;
    }

    public String randomAlphaNumeric() {
        String alpha = RandomStringUtils.randomAlphabetic(3);
        String numeric = RandomStringUtils.randomNumeric(3);
        return (alpha + "@" + numeric);
    }
}
