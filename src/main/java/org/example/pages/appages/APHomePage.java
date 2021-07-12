package org.example.pages.appages;

import org.example.hooksetup.HookSetup;
import org.example.utils.ActionHelpers;
import org.example.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class APHomePage extends HookSetup {
    private WebDriver driver;

    @FindBy(xpath="//a[@class='login']")
    public WebElement lnk_signin;

    @FindBy(id="email")
    public WebElement txt_email;

    @FindBy(id="passwd")
    public WebElement txt_pwd;

    @FindBy(id="SubmitLogin")
    public WebElement btn_signin;

    @FindBy(xpath="//a[@class='logout']")
    public WebElement lnk_logout;

    public APHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public  void navigateURL(String URL){
        driver.get(URL);
    }

    public void enterUsername(String username) {
        txt_email.sendKeys(username);
    }

    public void enterpwd(String pwd) {
        txt_pwd.sendKeys(pwd);
    }

    public void clickLoginLink() {
        lnk_signin.click();
    }

    public void clickLoginButton() {
        btn_signin.click();
    }

    public void loginValidUser(String username, String pwd) {
        WaitHelpers.WaitForElementVisible(lnk_signin,2);
        lnk_signin.click();
        txt_email.sendKeys(username);
        txt_pwd.sendKeys(pwd);
        btn_signin.click();
    }

    public void validateLogoutDisplayed() {
        ActionHelpers.JSScrollIntoView(lnk_logout);
        lnk_logout.isDisplayed();
    }
}
