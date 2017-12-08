package base;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Properties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
                return new EdgeDriver();
            case "mobile-chrome":
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir")+"/drivers/chromedriver.exe");
                Map<String,String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName","iPhone 6");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                return new ChromeDriver(chromeOptions);
            case "chrome":
            default:
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            return new ChromeDriver();
        }
    }
    public static RemoteWebDriver getRemoteDriver(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = null;
        switch (browser) {
            case "firefox":
                capabilities = DesiredCapabilities.firefox();
                break;
            case "edge":
                capabilities = DesiredCapabilities.edge();
                break;
            case "chrome":
            default:
                capabilities = DesiredCapabilities.chrome();
        }
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
    public static WebDriver getConfiguredDriver(String browser){
        WebDriver driver = getDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getConfiguredRemoteDriver(String browser) throws MalformedURLException {
        WebDriver driver = getRemoteDriver(browser);
        driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void quitDriver(WebDriver driver){
        driver.quit();
    }
}
