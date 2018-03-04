package by.epam.atm.lecture9.pages;

import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import by.epam.atm.utiles.CustomLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftMailPage extends AbstractPage {

    @FindBy(xpath="//body[@id='tinymce']//div[contains(text(),'Automation mentoring program')]")
    private List<WebElement> checkBody;

    @FindBy(xpath="//div[@id='LEGO']//a[@href='/messages/drafts/']")
    private WebElement emailDraftsEnter2;

    public DraftMailPage(WebDriverDecorator driver) {
        super(driver);
    }

    public boolean isBodyCorrect() {
        driver.switchTo().frame(0);
        return isElementPresent(checkBody);
    }

    public DraftsPage sendMailGoDraftsAgain(){

        driver.switchTo().defaultContent();
        driver.scriptExecutor("document.querySelector(\"div#b-toolbar__right div[data-name='send']\").click()");
        CustomLogger.info("Clicking Send button by javascript action");

        //Enter Drafts again
        CustomWaiter.waitUntilVisible(emailDraftsEnter2);
        driver.click(emailDraftsEnter2);

        return new DraftsPage(driver);}
}
