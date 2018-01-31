package by.epam.atm.patterns.factorymethod;

import by.epam.atm.utiles.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriverCreator implements WebDriverFactory {

    private WebDriver driver;
    private CustomWaiter timeout;

    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        timeout = new CustomWaiter(driver,10);
        return driver;
    }
}
