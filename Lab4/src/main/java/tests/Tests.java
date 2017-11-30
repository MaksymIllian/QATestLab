package tests;

import org.openqa.selenium.WebDriver;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.Shop.AllGoodsPage;
import pages.Shop.GoodPage;
import pages.Shop.MainPage;
import pages.admin.DashboardPage;
import pages.admin.GoodsPage;
import pages.admin.LoginPage;
import pages.admin.NewGoodPage;
import utils.Good;

/**
 * Created by User on 15.11.2017.
 */
public class Tests extends BaseTest {

    private static WebDriver driver;
    private static Good good;
    private static SoftAssert softAssert;
    @Test(dataProvider = "loginData")
    private static void login(String email, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillEmailInput(email);
        loginPage.fillPasswordInput(password);
        loginPage.submit();
    }
    private static void initGood(){
        good = new Good();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw"}
        };
    }
    @BeforeSuite
    private static void initDriver(){
        driver = getConfiguredDriver();
        initGood();
    }
    @BeforeMethod
    public void initSoftAssert() {
        softAssert = new SoftAssert();
    }
    @Test
    private static void test1() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.moveToCatalog();
        dashboardPage.goodsClick();

        GoodsPage goodsPage = new GoodsPage(driver);
        goodsPage.newGoodButtonClick();

        NewGoodPage newGoodPage = new NewGoodPage(driver);
        newGoodPage.fillGoodName(good.getName());
        newGoodPage.fillGoodCount(good.getCount());
        newGoodPage.fillGoodPrice(good.getPrice());
        newGoodPage.switchButtonClick();
        newGoodPage.saveButtonClick();
    }
    @Test
    private static void test2() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.allGoodsClick();

        AllGoodsPage allGoodsPage = new AllGoodsPage(driver);
        allGoodsPage.setGoodName(good.getName());
        allGoodsPage.searchGood();
        softAssert.assertTrue(allGoodsPage.getGood().isDisplayed(),"Good is not displayed!");
        allGoodsPage.addedGoodClick();

        GoodPage goodPage = new GoodPage(driver);
        softAssert.assertEquals(goodPage.getGoodName(),good.getName()+"jhfgj","Names is not equal!");
        softAssert.assertEquals(goodPage.getGoodPrice(), good.getPrice(),"Prices is not equal!");
        softAssert.assertAll();

    }
    @AfterSuite
    private static void quitDriver() {
        quitDriver(driver);
    }
}
