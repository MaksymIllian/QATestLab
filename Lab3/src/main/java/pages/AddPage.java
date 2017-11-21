package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class AddPage {
    private WebDriver driver;

    private By name = By.id("name_1");
    private By submit = By.id("category_form_submit_btn");

    public AddPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillNameInput(String rName){

        driver.findElement(name).sendKeys(rName);
    }

    public void submit(){
        driver.findElement(submit).click();
    }


}
