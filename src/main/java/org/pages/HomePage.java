package org.pages;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;

public class HomePage extends Base {
    public HomePage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void navigateTo(String url) {
        goToPage(url);
        logger.info(url + "linkine gidildi.");
    }

    public String getTitle() {
        String title = getDriver().getTitle();
        logger.info(title + "baslik kontrol edildi");
        return title;
    }

    public void searchInput(String q) {
        sendInput(By.id("search_input"), q + Keys.RETURN);
    }
}
