package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.Properties;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 15.11.2017.
 */
public abstract class BaseTest {
    private static WebDriver getDriver(){
        String browser = Properties.getBrowser();
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        new File(BaseTest.class.getResource("/geckodriver.exe").getFile()).getPath());
                return new FirefoxDriver();
            case "ie":
            case "internet explorer":
                System.setProperty("webdriver.ie.driver",
                        new File(BaseTest.class.getResource("/IEDriver.exe").getFile()).getPath());
                return new InternetExplorerDriver();
            case "chrome":
            default:
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            return new ChromeDriver();
        }
    }
    public static WebDriver getConfiguredDriver(){
        WebDriver driver = getDriver();
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}
