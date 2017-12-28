package by.epam.atm.lecture5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        return new WebDriverWait(driver, 5);
    }
}
