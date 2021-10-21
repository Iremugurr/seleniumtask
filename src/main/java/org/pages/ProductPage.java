package org.pages;


import org.apache.log4j.Logger;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

// a[class="lazy-load-button"]
public class ProductPage extends Base {
    public ProductPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void showMore(){
        scrollAndClick(By.cssSelector("a[class='lazy-load-button']"));
        logger.info("Daha fazla urun gor");
    }
    public List<WebElement> findElements(By by) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));

    }

    /*According to solution on web : List <WebElement> listings = driver.findElements(By.cssSelector("a[href*='/listing?listingid']"));
Random r = new Random();
int randomValue = r.nextInt(listings.size()); //Getting a random value that is between 0 and (list's size)-1
listings.get(randomValue).click(); //Clicking on the random item in the list. */
    public WebElement selectRandomProduct(String xpath) {
        List<WebElement> elements = findElements(By.xpath(xpath));
        int listSize = elements.size();
        Random random = new Random();
        int index = random.nextInt(listSize);
        WebElement element = findElement(By.xpath(xpath + "[" + index + "]"));
        return element;
    }
    public void selectRandomProduct() {
        WebElement element = selectRandomProduct("//*[@class='row c-items']/div");
        element.click();
        logger.info("Rastgele bir urun secildi");
    }
    public void addToBasket() {
        clickElement(By.id("pd_add_to_cart"));
        logger.info("urun sepete eklendi");
    }
}


