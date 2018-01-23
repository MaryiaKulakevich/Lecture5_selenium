package by.epam.atm.lecture5.pages;

import by.epam.atm.lecture5.utiles.HighlightElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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

    public WebDriverWait explicitTimeout() {
        return new WebDriverWait(driver, 10);
    }

    public void highlightElement(WebElement element) {
        HighlightElement.highlightElement(element, driver);
    }

}
