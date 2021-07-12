package org.example.hooksetup;

import io.cucumber.java.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.enums.Browsers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class MainHook {
    HookSetup hookSetup;

    private static final Logger log = LogManager.getLogger(MainHook.class);

    @Before
    public void initializeTest() {
        hookSetup = new HookSetup();
        hookSetup.browserSetup(Browsers.CHROME.name());
    }

    //Step hooks invoked before and after a step.
    // If a BeforeStep hook is executed the AfterStep hooks will also be executed regardless of the result of the step.
    // If a step did not pass, the following step and its hooks will be skipped.
    @BeforeStep
    public void beforeStep() {
        log.info("++++++Before Step+++++++");

    }

    @AfterStep
    public void afterStep() {
        log.info("++++++After Step++++++++");

    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
                log.info(scenario.getName() + " is Failed");
                final byte[] screenshot = ((TakesScreenshot) HookSetup.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png","New"); // ... and embed it in
            } catch (WebDriverException e) {
                e.printStackTrace();
            }

        } else {
            try {
                log.info(scenario.getName() + " is pass");
                scenario.attach(((TakesScreenshot) hookSetup.driver).getScreenshotAs(OutputType.BYTES), "image/png","NewName");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        HookSetup.driver.quit();
    }
}
