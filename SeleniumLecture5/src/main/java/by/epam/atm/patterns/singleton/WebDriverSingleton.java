package by.epam.atm.patterns.singleton;

import by.epam.atm.patterns.factorymethod.ChromeDriverCreator;
import by.epam.atm.patterns.factorymethod.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getWebDriverInstance(){
        if (driver == null){
            WebDriverFactory creator = new ChromeDriverCreator();
            driver = creator.createWebDriver();
        }
        return driver;
    }
}
