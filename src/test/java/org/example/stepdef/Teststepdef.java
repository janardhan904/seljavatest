package org.example.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.hooksetup.Hooksetup;
import org.example.pages.appages.APHomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Teststepdef{
    WebDriver driver = Hooksetup.getDriver();
    APHomePage aphomepage = new APHomePage(driver);

    @Given("user is  on homepage")
    public void user_is_on_homepage() throws IOException {
        aphomepage.navigateURL("http://automationpractice.com/index.php");
    }

    @When("user navigates to Login Page")
    public void user_navigates_to_login_page() {
        aphomepage.clickLoginLink();
    }

    @When("user enters username and Password")
    public void user_enters_username_and_password() {
        aphomepage.enterUsername("janardhan.reddy75@gmail.com");
        aphomepage.enterpwd("janardhan@123");
        aphomepage.clickLoginButton();
    }

    @Then("success message is displayed")
    public void success_message_is_displayed() {
        Assert.assertEquals("My account - My Store", driver.getTitle());
        driver.quit();
    }
}
