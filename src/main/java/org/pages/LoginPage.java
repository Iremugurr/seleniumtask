package org.pages;

import org.apache.log4j.Logger;
import org.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {
    public LoginPage(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    public void writeEmail(String q) {
        sendInput(By.id("LoginEmail"), q );
    }

    public void writePassword(String q) {
        sendInput(By.id("Password"), q );
    }

}
