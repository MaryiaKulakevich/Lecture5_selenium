package by.epam.atm.lecture5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DraftsPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-subject='lecture5 selenium']")
    private List<WebElement> savedMail;

    @FindBy(xpath = "//div[text()='mentee2017@mail.ru']")
//    @FindBy(xpath ="//a[@data-title='mentee2017 <mentee2017@mail.ru>']")
    private List<WebElement> checkAddressee;

    @FindBy(xpath = "//div[text()='lecture5 selenium']")
    private List<WebElement> checkSubject;

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

    public boolean isSubjectCorrect() {
        return isElementPresent(checkSubject);
    }

    public DraftMailPage openDraft() {
        checkSubject.get(0).click();
        return new DraftMailPage(driver);
    }

    public boolean isMailPresent() {
        explicitTimeout().until(ExpectedConditions.invisibilityOfAllElements(savedMail));
        return isElementPresent(savedMail);
    }

    public SentPage goToSent() {
        clickSent.click();
        return new SentPage(driver);
    }

}
