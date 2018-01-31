package by.epam.atm.lecture8.pages;

import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftMailPage extends AbstractPage {

    @FindBy(xpath="//body[@id='tinymce']//div[contains(text(),'Automation mentoring program')]")
    private List<WebElement> checkBody;

    @FindBy(xpath="//div[@id='LEGO']//a[@href='/messages/drafts/']")
    private WebElement emailDraftsEnter2;

    public DraftMailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBodyCorrect() {
        driver.switchTo().frame(0);
//        highlightElement(checkBody.get(0));
        return isElementPresent(checkBody);
    }

    public DraftsPage sendMailGoDraftsAgain(){

        driver.switchTo().defaultContent();
        ((WebDriverDecorator)driver).scriptExecutor("document.querySelector(\"div#b-toolbar__right div[data-name='send']\").click()");

        //Enter Drafts again
        explicitTimeout().waitUntilClickable(emailDraftsEnter2);
        emailDraftsEnter2.click();

        return new DraftsPage(driver);}
}
