package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import utils.Properties;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 15.11.2017.
 */
public abstract class BaseTest {
    private static WebDriver getDriver(String browser){
        //String browser = Properties.getBrowser();
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir")+"/drivers/geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
            case "microsoft":
                System.setProperty("webdriver.edge.driver",
                        System.getProperty("user.dir")+"/drivers/MicrosoftWebDriver.exe");
            //    InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            //    internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
             //   internetExplorerOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
             //   internetExplorerOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR,true);
             //   internetExplorerOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
             //   internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                return new EdgeDriver();
            case "chrome":
            default:
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            return new ChromeDriver();
        }
    }
    public static WebDriver getConfiguredDriver(String browser){
        WebDriver driver = getDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}
