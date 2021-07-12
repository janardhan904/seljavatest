package org.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionHelpers {
    private static final Logger log = LogManager.getLogger(WaitHelpers.class);
    private static WebDriver driver;

    public ActionHelpers(WebDriver driver){
        this.driver = driver;
    }
    public static void JSScrollIntoView(WebElement element){
        log.info("Scroll into the element...");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
}
