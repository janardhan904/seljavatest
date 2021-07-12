package org.example.hooksetup;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooksetup {
    public static WebDriver driver;
    public static Properties prop;

    public Hooksetup()  {
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/org/example"
                    + "/config/config.properties");
            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait driverWait(long timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds);
    }

    //Before hooks run before the first step of each scenario.
    @Before
    public WebDriver browserSetup() {
        System.out.println("++++++Before hooks+++++++");

        String browserName = prop.getProperty("browser");
        String projectPath = System.getProperty("user.dir");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "/drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    //Step hooks invoked before and after a step.
    // If a BeforeStep hook is executed the AfterStep hooks will also be executed regardless of the result of the step.
    // If a step did not pass, the following step and its hooks will be skipped.
    @BeforeStep
    public void beforeStep() {
        System.out.println("++++++Before Step+++++++");

    }

    @AfterStep
    public void afterStep() {
        System.out.println("++++++After Step++++++++");

    }

    @After
    public void tearDown() {
        System.out.println("++++++After Hook++++++++");

        driver.close();
        driver.quit();

    }
}
