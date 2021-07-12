package org.example.pages.appages;

import org.example.hooksetup.Hooksetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class APHomePage extends Hooksetup{
    private WebDriver driver;
    private By txt_email = By.id("email");
    private By txt_pwd = By.id("passwd");
    private By lnk_signin = By.xpath("//a[@class='login']");
    private By btn_signin = By.id("SubmitLogin");
    private By lnk_logout = By.xpath("//a[@class='logout']");

    public APHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        if (!getDriver().getTitle().equals("My Store")) {
//            throw new IllegalStateException("This is not login page "+ driver.getCurrentUrl());
//        }
    }

    public  void navigateURL(String URL){
        driver.get(URL);
    }

    public void enterUsername(String username) {
        driver.findElement(txt_email).sendKeys(username);
    }

    public void enterpwd(String pwd) {
        driver.findElement(txt_pwd).sendKeys(pwd);
    }

    public void clickLoginLink() {
        driver.findElement(lnk_signin).click();
    }

    public void clickLoginButton() {
        driver.findElement(btn_signin).click();
    }

    public void loginValidUser(String username, String pwd) {
        driver.findElement(lnk_signin).click();
        driver.findElement(txt_email).sendKeys(username);
        driver.findElement(txt_pwd).sendKeys(pwd);
        driver.findElement(btn_signin).click();
    }

    public void validateLogoutDisplayed() {
        driver.findElement(lnk_logout).isDisplayed();

    }
}
