package org.example.pages;

import org.example.hooksetup.HookSetup;
import org.example.utils.ActionHelpers;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UQHomePage extends HookSetup {
    private static WebDriver driver;

    @FindBy(xpath="//a[text()='Fill out forms']")
    public WebElement linkFill;

    @FindBy(xpath = "//div[1]/div/div[2]/form/p[1]//input[contains(@id,'contact_name')]")
    public  WebElement nameOne;

    @FindBy(xpath = "//div[1]/div/div[2]/form/p[2]//textarea[contains(@id,'contact_message')]")
    public  WebElement messageOne;

    public UQHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateURL(String URL){
        driver.get(URL);
    }

    public void clickLinkFill(){
        linkFill.click();
    }

    public void enterNameMessage(String name, String message){
        nameOne.sendKeys(name);
        messageOne.sendKeys(message);
    }
}
