package org.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    WebDriver driver;
    public WebDriverWait wait;
    JavascriptExecutor executor;
    public static Logger logger ;



    public Base(WebDriver driver , Logger logger ) {
        this.driver = driver;
        this.logger = logger;
        wait = new WebDriverWait(this.driver, 45, 500);
    }
    // finds spesific element in webpage
    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void scrollAndClick(By by) {
        WebElement element = findElement(by);
        executor();
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void executor (){
        JavascriptExecutor js=((JavascriptExecutor) driver) ;
        js.executeScript("window.scroll(0,7000)");
    }

    public void clickElement(By by) {
        WebElement element = findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public JavascriptExecutor getExecutor() {
        executor = (JavascriptExecutor) driver;
        return executor;
    }

    // Charsquence -> pantolon ... - by is element
    public void sendInput(By by, CharSequence inputText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        findElement(by).sendKeys(inputText);
    }

    public void goToPage(String url) {
        driver.get(url);
    }

    // sets chrome web driver
    public WebDriver getDriver() {

        return driver;
    }
}
