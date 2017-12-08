package pages.Shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class OrderPage extends BasePage {

    private By genderMale = By.xpath("//input[@value=1]");
    private By inputName = By.xpath("//input[@name=\"firstname\"]");
    private By inputLastName = By.xpath("//input[@name=\"lastname\"]");
    private By inputEMail = By.xpath("//input[@name=\"email\"]");

    private By inputAddress = By.xpath("//input[@name=\"address1\"]");
    private By inputPostCode = By.xpath("//input[@name=\"postcode\"]");
    private By inputCity = By.xpath("//input[@name=\"city\"]");

    private By inputCheckPayment = By.xpath("//input[@id=\"payment-option-1\"]/..");
    private By agreeCheck = By.xpath("//li/div[@class=\"pull-xs-left\"]");

    private By dataSubmitButton = By.xpath("//button[@name=\"continue\"]");
    private By addressSubmitButton = By.xpath("//button[@name=\"confirm-addresses\"]");
    private By deliverySubmitButton = By.xpath("//button[@name=\"confirmDeliveryOption\"]");
    private By endSubmitButton = By.xpath("//div[@class=\"ps-shown-by-js\"]/button");

    public OrderPage(WebDriver driver){
        this.driver = driver;
    }

    private static String generateString() {
        return Double.toString(Math.random());
    }
    public void genderMaleClick(){
        elementVisibilityWait(genderMale);
        driver.findElement(genderMale).click();
    }
    public void fillInputName(){
        elementVisibilityWait(inputName);
        fillInput(inputName,"TestName");
    }
    public void fillInputLastName(){
        elementVisibilityWait(inputLastName);
        fillInput(inputLastName,"TestLName");
    }
    public void fillInputEmail(){
        elementVisibilityWait(inputEMail);
        fillInput(inputEMail,generateString()+"@gmail.com");
    }

    public void fillInputAddress(){
        elementVisibilityWait(inputAddress);
        fillInput(inputAddress,"TestAddress");
    }
    public void fillInputPostCode(){
        elementVisibilityWait(inputPostCode);
        fillInput(inputPostCode,"11111");
    }
    public void fillInputCity(){
        elementVisibilityWait(inputCity);
        driver.findElement(inputCity).sendKeys("City");
    }
    public void inputCheckPaymentClick(){
        elementVisibilityWait(inputCheckPayment);
        driver.findElement(inputCheckPayment).click();
    }
    public void agreeCheckClick(){
        elementVisibilityWait(agreeCheck);
        driver.findElement(agreeCheck).click();
    }
    public void dataSubmitButtonClick(){
        elementVisibilityWait(dataSubmitButton);
        driver.findElement(dataSubmitButton).click();
    }
    public void addressSubmitButtonClick(){
        elementVisibilityWait(addressSubmitButton);
        driver.findElement(addressSubmitButton).click();
    }
    public void deliverySubmitButtonClick(){
        elementVisibilityWait(deliverySubmitButton);
        driver.findElement(deliverySubmitButton).click();
    }
    public void endSubmitButtonClick(){
        elementVisibilityWait(endSubmitButton);
        elementClickableWait(endSubmitButton);
        driver.findElement(endSubmitButton).click();
    }

}
