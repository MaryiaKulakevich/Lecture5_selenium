package by.epam.atm.patterns.singleton;

import by.epam.atm.patterns.factorymethod.ChromeDriverCreator;
import by.epam.atm.patterns.factorymethod.FireFoxDriverCreator;
import by.epam.atm.patterns.factorymethod.WebDriverFactory;
import by.epam.atm.utiles.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getWebDriverInstance(WebDriverType type) throws UnknownDriverTypeException {
        if (driver == null) {
            CustomLogger.info ("Getting an instance of web driver: " + type);
            switch (type) {
                case CHROME: {
                    WebDriverFactory creator = new ChromeDriverCreator();
                    driver = creator.createWebDriver();
                    break;
                }
                case FIREFOX: {
                    WebDriverFactory creator = new FireFoxDriverCreator();
                    driver = creator.createWebDriver();
                    break;
                }
                default:
                    try {
                        throw new UnknownDriverTypeException("Unknown web driver type: " + type);
                    } catch (UnknownDriverTypeException e) {
                        CustomLogger.error("Unknown web driver type: " + type, e);
                }
            }
        }
        return driver;
    }
}
