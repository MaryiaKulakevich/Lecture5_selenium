package by.epam.atm.lecture9.pages;

import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-subject='lecture9 selenium']")
    private List<WebElement> savedMail;

    @FindBy(xpath = "//div[text()='mentee2017@mail.ru']")
    private List<WebElement> checkAddressee;

    @FindBy(xpath = "//div[@data-id='500000']/a[@href='/messages/sent/']")
    private WebElement clickSent;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSaved() {
        return isElementPresent(savedMail);
    }

    public boolean isAddresseeCorrect() {
        return isElementPresent(checkAddressee);
    }

    public DraftMailPage openDraft() {
        savedMail.get(0).click();
        return new DraftMailPage(driver);
    }

    public boolean isMailPresent() {
        CustomWaiter.waitUntilInvisible(driver, 10, savedMail);
        return isElementPresent(savedMail);
    }

    public SentPage goToSent() {
        clickSent.click();
        return new SentPage(driver);
    }

}
