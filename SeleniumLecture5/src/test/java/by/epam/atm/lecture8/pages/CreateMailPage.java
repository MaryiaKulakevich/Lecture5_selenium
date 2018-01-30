package by.epam.atm.lecture8.pages;

import by.epam.atm.lecture8.bo.Letter;
import by.epam.atm.patterns.decorator.WebDriverDecorator;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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

    public CreateMailPage(WebDriver driver) {
        super(driver);
    }

    public DraftsPage createAndSaveMail(Letter letter) throws UnknownDriverTypeException {
        //Enter To value
        emailToField.sendKeys(letter.getRecipient());

        //Enter Subject value
        emailSubjectField.sendKeys(letter.getSubject());

        //Switch to body, enter body text and save the draft

        ((WebDriverDecorator)driver).createAction()
                .sendKeys(emailSubjectField, Keys.TAB)
                .sendKeys(letter.getBody()).keyDown(Keys.CONTROL).sendKeys("s")
                .keyUp(Keys.CONTROL)
                .build().perform();

        //Wait until the mail is saved
        explicitTimeout().waitUntilVisible(mailSaved);

        //Enter Drafts
        emailDraftsEnter.click();
        return new DraftsPage(driver);
    }
}
