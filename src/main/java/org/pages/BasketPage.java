package org.pages;
import org.apache.log4j.Logger;
import org.base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends Base {



    public BasketPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }
    public void goToBasket() {
        clickElement(By.cssSelector("i[class='header-bag-icon bndl-shopping-bag bndl-shopping-bag-dims']"));
        logger.info("Sepete gidilir");
    }
    String ProductPrice = "";
    public void setProductPrice() {
        ProductPrice= findElement(By.xpath("//*[@id=\"rightInfoBar\"]/div[1]/div/div[2]/div/div/div/span[2]")).getText();
    }
    String BasketPrice = "";
    public void setBasketPrice(){
        BasketPrice = findElement(By.cssSelector("span[class='rd-cart-item-price mb-15']")).getText();
    }

    public void comparePrice() {
        Assert.assertEquals(ProductPrice,BasketPrice);
        logger.info("Urun fiyati karsilastirildi. Urun fiyatı : " + ProductPrice + "Sepet fiyatı:"+ BasketPrice );
    }

    public void deleteButton() {
        clickElement(By.cssSelector("a[class='inverted-modal-button sc-delete ins-init-condition-tracking']"));
        logger.info("Sepetteki urunler silinir");
    }
}

