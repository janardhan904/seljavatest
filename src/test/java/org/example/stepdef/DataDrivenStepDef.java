package org.example.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.hooksetup.HookSetup;
import org.example.pages.UQHomePage;
import org.example.pages.appages.APHomePage;
import org.openqa.selenium.WebDriver;

public class DataDrivenStepDef {
    WebDriver driver = HookSetup.getDriver();
    UQHomePage uqHomePage = new UQHomePage(driver);

    @Given("user go to {string} UltimateQa HomePage")
    public void userGoToHttpsUltimateqaComAutomationUltimateQaHomePage(String url) {
        uqHomePage.navigateURL(url);
    }

    @When("user navigates to Forms Page")
    public void userNavigatesToFormsPage() {
        uqHomePage.clickLinkFill();
    }

    @And("^user enters (.*) and (.*)$")
    public void userEntersNameAndMessage(String name, String message) {
        uqHomePage.enterNameMessage(name,message);
    }

    @Then("Verify success message")
    public void verifySuccessMessage() {
        //
    }
}
