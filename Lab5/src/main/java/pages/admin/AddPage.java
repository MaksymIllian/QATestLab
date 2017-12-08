package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AddPage extends BasePage {
   // private WebDriver driver;

    private By name = By.id("name_1");
    private By submit = By.id("category_form_submit_btn");

    public AddPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillNameInput(String rName){
        elementVisibilityWait(name);
        driver.findElement(name).sendKeys(rName);
    }

    public void submit(){
        elementVisibilityWait(submit);
        driver.findElement(submit).click();
    }


}
