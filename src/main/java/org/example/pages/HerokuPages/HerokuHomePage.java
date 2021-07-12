package org.example.pages.HerokuPages;

import org.example.hooksetup.HookSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HerokuHomePage extends HookSetup {

    public HerokuHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
