package by.epam.atm.patterns.factorymethod;

import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverCreator implements WebDriverFactory {

    private WebDriver driver;
    private CustomWaiter waiter;
    private long time = 10;

    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        CustomWaiter.waitImplicitly(driver, time);
        return driver;
    }
}
