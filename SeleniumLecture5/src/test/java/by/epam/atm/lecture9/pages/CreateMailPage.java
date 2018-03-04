package by.epam.atm.lecture9.pages;

import by.epam.atm.lecture9.bo.Letter;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import by.epam.atm.utiles.CustomLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateMailPage extends AbstractPage {

    @FindBy(xpath = "//textarea[@tabindex='4']")
    private WebElement emailToField;

    @FindBy(css = "div.compose-head__field>input.b-input")
    private WebElement emailSubjectField;

    @FindBy(xpath = "//div[@class='b-sticky']//a[@href='/messages/drafts']")
    private List<WebElement> mailSaved;

    @FindBy(xpath = "//div[@data-id='500001']//span[@class='b-nav__item__text']")
    private WebElement emailDraftsEnter;

    public CreateMailPage(WebDriverDecorator driver) {
        super(driver);
    }

    public DraftsPage createAndSaveMail(Letter letter) throws UnknownDriverTypeException {
        //Enter To value
        driver.type(emailToField, letter.getRecipient());

        //Enter Subject value
        driver.type(emailSubjectField, letter.getSubject());

        //Switch to body, enter body text and save the draft
        driver.createAction()
                .sendKeys(emailSubjectField, Keys.TAB)
                .sendKeys(letter.getBody()).keyDown(Keys.CONTROL).sendKeys("s")
                .keyUp(Keys.CONTROL)
                .build().perform();
        CustomLogger.info("Executing a sequence of keyboard actions");

        //Wait until the mail is saved
        CustomWaiter.waitUntilAllVisible(mailSaved);

        //Enter Drafts
        driver.click(emailDraftsEnter);
        return new DraftsPage(driver);
    }
}
