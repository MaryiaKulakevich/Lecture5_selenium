package by.epam.atm.lecture9.pages;

import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import by.epam.atm.utiles.CustomLogger;
import by.epam.atm.utiles.HighlightElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SentPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-subject='lecture9 selenium']")
    private List<WebElement> sentMail;

    @FindBy(xpath = "//div[@id='b-nav_folders']//a[@href='/messages/trash/']")
    private WebElement bin;

    @FindBy(id = "PH_logoutLink")
    private WebElement searchLogout;

    public SentPage(WebDriverDecorator driver) {
        super(driver);
    }

    public boolean isMaleSent() {
        return isElementPresent(sentMail);
    }

    public boolean isMailRemoved() {
        CustomWaiter.waitUntilAllInvisible(sentMail);
        return isElementPresent(sentMail);
    }

    public void removeMailFromSent() {
        driver.createAction().dragAndDrop(sentMail.get(0), bin).build().perform();
        CustomLogger.info("Executing drag and drop mouse action");
    }

    public void logout() {
        //Log out
        driver.click(searchLogout);
        CustomLogger.info("Logout");
    }

}
