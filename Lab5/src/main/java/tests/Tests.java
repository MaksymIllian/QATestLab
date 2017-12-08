package tests;

import org.openqa.selenium.WebDriver;

import base.BaseTest;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.Shop.*;
import utils.Good;

import java.net.MalformedURLException;

/**
 * Created by User on 15.11.2017.
 */
public class Tests extends BaseTest {

    private static WebDriver driver;
    private static Good good;
    private static SoftAssert softAssert;

    private static void initGood(){
        good = new Good();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }
    @BeforeClass
    @Parameters("selenium.browser")
    private static void init(@Optional("chrome") String browser) throws MalformedURLException {
        driver = getConfiguredRemoteDriver(browser);
//        driver = getConfiguredDriver(browser);
    }
    @BeforeMethod
    public void initSoftAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    private static void versionTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        boolean verify = mainPage.imgIsPresent();
        if(verify)
            softAssert.assertTrue(verify,"It must be desktop version");
        else softAssert.assertTrue(verify,"It must be mobile version");
    }

    private static void fillOrder(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillInputName();
        orderPage.fillInputLastName();
        orderPage.fillInputEmail();
        orderPage.dataSubmitButtonClick();

        orderPage.fillInputAddress();
        orderPage.fillInputCity();
        orderPage.fillInputPostCode();
        orderPage.addressSubmitButtonClick();

        orderPage.deliverySubmitButtonClick();

        orderPage.inputCheckPaymentClick();
        orderPage.agreeCheckClick();
        orderPage.endSubmitButtonClick();
    }
    @Test
    private static void test1() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.allGoodsClick();

        AllGoodsPage allGoodsPage = new AllGoodsPage(driver);
        allGoodsPage.randomGoodClick();


        GoodPage goodPage = new GoodPage(driver);
        good = new Good(goodPage.getGoodName(), goodPage.getGoodPrice(), goodPage.getGoodsCount(), driver.getCurrentUrl());
        System.out.println(goodPage.getGoodName());
        goodPage.addToCart();
        goodPage.confirmClick();

        CartPage cartPage = new CartPage(driver);
        softAssert.assertEquals(cartPage.getGoodName(),good.getName().toLowerCase(),"Product Names is not equals");
        softAssert.assertEquals(cartPage.getGoodPrice(),good.getPrice(),"Product prices is not equals");
        softAssert.assertEquals(cartPage.getGoodsCount(),Integer.toString(1),"Products count is not equal 1");
        cartPage.confirmClick();

        fillOrder();

        ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage(driver);
        softAssert.assertTrue(confirmOrderPage.getDetailsName().toLowerCase().contains(good.getName().toLowerCase()),"The good name is different");
        softAssert.assertEquals(confirmOrderPage.getConfirmMessage(),"ваш заказ подтверждён","Message must be 'Ваш заказ подтверждён'");
        softAssert.assertEquals(confirmOrderPage.getDetailsCount(),Integer.toString(1),"Count must be 1");
        softAssert.assertEquals(confirmOrderPage.getDetailsPrice(), good.getPrice(),"Prices must be equals");

        driver.navigate().to(good.getGoodURL());
        System.out.println(goodPage.getGoodName());
        goodPage= new GoodPage(driver);
        goodPage.getGoodsCount();
        softAssert.assertEquals(Integer.toString(Integer.parseInt(good.getCount())-1), goodPage.getGoodsCount(),"The goods count must be");
        softAssert.assertAll();


    }
    @AfterClass
    private static void quitDriver() {
        quitDriver(driver);
    }
}
