package by.epam.atm.patterns.factorymethod;

import by.epam.atm.utiles.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class FireFoxDriverCreator implements WebDriverFactory {

    private WebDriver driver;
    private CustomWaiter waiter;
    private long time = 10;

    public WebDriver createWebDriver() {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        driver = new FirefoxDriver(options);
        waiter = new CustomWaiter(driver,time);
        waiter.waitImplicitly();
        return driver;
    }
}
