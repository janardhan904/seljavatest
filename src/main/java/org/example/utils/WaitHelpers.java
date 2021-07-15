package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelpers {
    private static final Logger log = LogManager.getLogger(WaitHelpers.class);
    private static WebDriver driver;

    public WaitHelpers(WebDriver driver){
        this.driver = driver;
    }

    public static void WaitForElementVisible(WebElement element, long timeOutInSeconds){
        log.info("waiting for element visibilityOf..");
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("element is visible..");
    }

    private static boolean isPageLoadedCompletedJS()
    {
        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
                || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

    public static void sleepFor(int millis) throws InterruptedException
    {
        Thread.sleep(millis);
    }

}
