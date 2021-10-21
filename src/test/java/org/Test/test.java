package org.Test;

import org.apache.log4j.Logger;
import org.base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.pages.BasketPage;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.pages.ProductPage;

public class test extends BaseTest {
    final static  Logger logger = Logger.getLogger(test.class.getName());

    @Test
    public void lcwSeleniumTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver, logger);
        LoginPage loginPage = new LoginPage(driver,logger);
        ProductPage productPage = new ProductPage(driver, logger);
        BasketPage basketPage = new BasketPage(driver, logger);
        logger.info("---------Test basladi --------");
        homePage.goToPage("https://www.lcwaikiki.com/tr-TR/TR");
        homePage.clickElement(By.cssSelector("a[href=\"https://www.lcwaikiki.com/tr-TR/TR/giris\"]"));
        loginPage.writeEmail("iremugur3232@gmail.com");
        loginPage.writePassword("test1234");
        loginPage.clickElement(By.id("loginLink"));

        logger.info("Giris yapildi.");
        homePage.clickElement(By.id("search_input"));
        homePage.searchInput("pantolon");
        logger.info("pantolon aratildi.");
        // product section
        productPage.showMore();
        productPage.selectRandomProduct();
        productPage.clickElement(By.xpath("//*[@id='option-size']/a[2]"));
        productPage.addToBasket();

        // basket section
        basketPage.setProductPrice();
        basketPage.goToBasket();
        basketPage.setBasketPrice();
        basketPage.comparePrice();
        basketPage.clickElement(By.cssSelector("a[class='oq-up plus']"));
        Thread.sleep(1000);
        basketPage.clickElement(By.cssSelector("a[class='cart-square-link']"));
        // waiting for modal
        Thread.sleep(500);
        basketPage.deleteButton();

        logger.info("---------Test bitti --------");
    }
}
