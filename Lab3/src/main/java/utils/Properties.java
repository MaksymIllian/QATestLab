package utils;


import org.openqa.selenium.remote.BrowserType;

/**
 * Created by User on 15.11.2017.
 */
public class Properties {
    private final static String DEFAULT_URL = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
    private final static String DEFAULT_BROWSER = BrowserType.CHROME;

    public static String getDefaultUrl(){
        return System.getProperty(EnvironmentVariables.BASE_ADMIN_URL.toString(),DEFAULT_URL);
    }
    public static String getBrowser(){
        return System.getProperty(EnvironmentVariables.BROWSER.toString(),DEFAULT_BROWSER);
    }


}
