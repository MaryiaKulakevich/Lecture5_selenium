package by.epam.atm.patterns.factorymethod;

import by.epam.atm.patterns.staticfactory.CustomWaiter;
import by.epam.atm.utiles.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverCreator implements WebDriverFactory {

    private WebDriver driver;
    private CustomWaiter waiter;
    private long time = 10;

    public WebDriver createWebDriver() {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
        CustomWaiter.waitImplicitly(driver, time);
        return driver;
    }
}
