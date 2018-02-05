package by.epam.atm.lecture10.tests;


import by.epam.atm.lecture10.pages.SentPage;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import by.epam.atm.patterns.singleton.WebDriverSingleton;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static by.epam.atm.patterns.singleton.WebDriverType.CHROME;

@CucumberOptions(strict = true, plugin = { "json:target/cucumber-report.json",
        "html:target/cucumber-report" }, tags = "@smokeTest", features = "src/test/resources/features_cucumber/mail_tests.feature", glue = {
        "by.epam.atm.lecture10.steps" })

public class MailDriverCucumberTestNgTest extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

    @BeforeClass(description = "Start browser")
    public void startBrowser() throws UnknownDriverTypeException {
        driver = WebDriverSingleton.getWebDriverInstance(CHROME);
        driver = new WebDriverDecorator(driver);
    }

    @AfterClass(description = "Log out and close browser")
    public void logOffStopBrowser() {
        new SentPage(driver).logout();
        driver.quit();
        System.out.println("Browser was successfully quited.");
    }
}
