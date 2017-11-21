package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Properties;

/**
 * Created by User on 15.11.2017.
 */
public class LoginPage {
    private WebDriver driver;

    private String emailInput = "webinar.test@gmail.com";
    private String passwordInput = "Xcg7299bnSmMuRLp9ITw";

    private By email = By.id("email");
    private By password = By.id("passwd");
    private By login = By.name("submitLogin");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(Properties.getDefaultUrl());
    }

    public void fillEmailInput(){
        driver.findElement(email).sendKeys(emailInput);
    }
    public void fillPasswordInput(){
        driver.findElement(password).sendKeys(passwordInput);
    }
    public void submit(){
        driver.findElement(login).click();
    }

}
