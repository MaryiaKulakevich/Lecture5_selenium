package by.epam.atm.lecture8.pages;


import by.epam.atm.utiles.CustomWaiter;
import by.epam.atm.utiles.HighlightAndScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(List<WebElement> element) {
        return element.size() > 0;
    }

    public CustomWaiter explicitTimeout(long time) { return new CustomWaiter(driver, time);
    }
}
