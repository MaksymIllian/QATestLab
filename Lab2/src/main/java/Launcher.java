import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Launcher {
    public static void main(String[] args){
        WebDriver driver = initWebDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        test1(driver, url);
        test2(driver, url);
        driver.quit();
    }
    public static void test1(WebDriver driver, String url){
        driver.get(url);
        login(driver);
        logout(driver);
    }
    public static void test2(WebDriver driver, String url){
        String[] menuElements = new String[]{"Dashboard", "Заказы", "Каталог","Клиенты", "Служба поддержки", "Статистика", "Modules",
                                        "Design", "Доставка", "Способ оплаты", "International", "Shop Parameters", "Конфигурация"};
        driver.get(url);
        login(driver);
        for (String element: menuElements
             ) {
            checkMenu(driver, element);
        }
    }
    public static void checkMenu(WebDriver driver, String element){
        WebElement menuElement = driver.findElement(By.linkText(element));
        menuElement.click();
        String expectedTitle = driver.getTitle();
        System.out.println("Current title: " + expectedTitle);
//        System.out.println(driver.getTitle());
        driver.navigate().refresh();
        String actualTitle = driver.getTitle();
//        System.out.println(actualTitle.getText());
        if(actualTitle.equals(expectedTitle)){
            System.out.println("User is staying at current page after refreshing");
        }else{
            System.out.println("User is not staying at current page after refreshing");
        }
    }
    public static void logout(WebDriver driver){
        WebElement dropdown = driver.findElement(By.id("header_employee_box"));
        dropdown.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
    }
    public static void login(WebDriver driver){
        String userEmail = "webinar.test@gmail.com";
        String userPassword = "Xcg7299bnSmMuRLp9ITw";
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(userEmail);
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys(userPassword);
        WebElement submit = driver.findElement(By.name("submitLogin"));
        submit.click();

    }
    public static WebDriver initWebDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
