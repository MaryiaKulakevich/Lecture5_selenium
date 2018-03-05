package by.epam.atm.lecture9.pages;


import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.utiles.CustomLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    protected WebDriverDecorator driver;

    public AbstractPage(WebDriverDecorator driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(List<WebElement> element) {
        boolean present = element.size() > 0;
        if (present == true) {
            CustomLogger.info(String.format("Element is present: %s", element.toString()));
        }
        else{
            CustomLogger.info(String.format("Element is not present: %s", element.toString()));
        }
        return present;
    }
}
