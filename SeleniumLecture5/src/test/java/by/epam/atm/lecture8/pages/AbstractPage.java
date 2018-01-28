package by.epam.atm.lecture8.pages;

import by.epam.atm.lecture8.utiles.HighlightAndScreenshot;
import by.epam.atm.lecture8.utiles.Waiter;
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

    public Waiter explicitTimeout() { return new Waiter(driver, 10);
    }

    public void highlightElement(WebElement element) {
        HighlightAndScreenshot.highlightElement(element, driver);
    }

}
