package by.epam.atm.lecture5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CreateMailPage extends AbstractPage{

    @FindBy(xpath="//textarea[@tabindex='4']")
    private WebElement emailToField;

    @FindBy(css="div.compose-head__field>input.b-input")
    private WebElement emailSubjectField;

    @FindBy(xpath="//body[@class='mceContentBody compose2']")
    private WebElement emailBodyField;

    @FindBy(xpath="//div[@class='b-sticky']//div[@data-name='saveDraft']")
    private WebElement emailSaveBtn;

    @FindBy(xpath="//div[@class='b-sticky']//a[@href='/messages/drafts']")
    private List<WebElement> mailSaved;

    @FindBy(xpath="//div[@data-id='500001']//span[@class='b-nav__item__text']")
    private WebElement emailDraftsEnter;

    public CreateMailPage(WebDriver driver) {
        super(driver);
    }

    public DraftsPage createAndSaveMail(String to, String subject, String body){
        //Enter To value
        emailToField.sendKeys(to);

        //Enter Subject value
        emailSubjectField.sendKeys(subject);

        //Switch to the frame of Body
        driver.switchTo().frame(0);

        //Enter Body
        emailBodyField.sendKeys(body);

        //return back to initial context
        driver.switchTo().defaultContent();

        //Save the email as a draft.
        emailSaveBtn.click();

        //Wait until the mail is saved
        explicitTimeout().until(ExpectedConditions.visibilityOfAllElements(mailSaved));

        //Enter Drafts
        emailDraftsEnter.click();

        return new DraftsPage(driver);
    }
}
