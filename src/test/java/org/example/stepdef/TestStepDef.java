package org.example.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.config.Loggers;
import org.example.hooksetup.HookSetup;
import org.example.pages.appages.APHomePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestStepDef{
    WebDriver driver = HookSetup.getDriver();
    APHomePage aphomepage = new APHomePage(driver);
    private static final Logger log = LogManager.getLogger(TestStepDef.class);

    @Given("user is  on homepage")
    public void user_is_on_homepage() throws IOException {
        log.info("Navigating to URL");
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
