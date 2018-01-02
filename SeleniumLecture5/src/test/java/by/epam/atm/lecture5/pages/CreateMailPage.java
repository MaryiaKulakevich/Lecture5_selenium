package by.epam.atm.lecture5.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class CreateMailPage extends AbstractPage{

    @FindBy(xpath="//textarea[@tabindex='4']")
    private WebElement emailToField;

    @FindBy(css="div.compose-head__field>input.b-input")
    private WebElement emailSubjectField;

//    @FindBy(xpath="//body[@class='mceContentBody compose2']")
//    private WebElement emailBodyField;

//    @FindBy(xpath="//div[@class='b-sticky']//div[@data-name='saveDraft']")
//    private WebElement emailSaveBtn;

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
//        new Actions(driver).sendKeys(emailToField, Keys.ENTER).sendKeys(emailToField, Keys.TAB).sendKeys(subject).build().perform();
        emailSubjectField.sendKeys(subject);

        //Switch to body, enter body text and save the draft
        new Actions(driver)
                .sendKeys(emailSubjectField, Keys.TAB)
                .sendKeys(body).keyDown(Keys.CONTROL).sendKeys("s")
                .keyUp(Keys.CONTROL)
                .build().perform();

//        driver.switchTo().frame(0);
//        emailBodyField.sendKeys(body);
//        driver.switchTo().defaultContent();
//        emailSaveBtn.click();

        //Wait until the mail is saved
        explicitTimeout().until(ExpectedConditions.visibilityOfAllElements(mailSaved));

        //Enter Drafts
        emailDraftsEnter.click();

        return new DraftsPage(driver);
    }
}
