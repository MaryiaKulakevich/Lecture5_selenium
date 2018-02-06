package by.epam.atm.lecture10.pages;

import by.epam.atm.lecture10.bo.Letter;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends AbstractPage {

//    @FindBy(xpath = "//a[@data-subject='lecture9 selenium']")
//    private List<WebElement> savedMail;

    private List<WebElement> savedMail;
    private String CHECK_MAIL_AVAILABILITY = String.format("//a[@data-subject='%s']", new Letter().getSubject());

    @FindBy(xpath = "//div[text()='mentee2017@mail.ru']")
    private List<WebElement> checkAddressee;

    @FindBy(xpath = "//div[@data-id='500000']/a[@href='/messages/sent/']")
    private WebElement clickSent;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSaved() {
        savedMail = driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
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
