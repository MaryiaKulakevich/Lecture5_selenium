package by.epam.atm.lecture5.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DraftMailPage extends AbstractPage {

//    @FindBy(xpath="//body[@id='tinymce']//div[contains(text(),'WebDriver is a remote control interface')]")
    @FindBy(xpath="//body[@id='tinymce']//div[contains(text(),'Automation mentoring program')]")
    private List<WebElement> checkBody;

    @FindBy(xpath="//div[@id='LEGO']//a[@href='/messages/drafts/']")
    private WebElement emailDraftsEnter2;

    public DraftMailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBodyCorrect() {
        driver.switchTo().frame(0);
        highlightElement(checkBody.get(0));
        return isElementPresent(checkBody);
    }

    public DraftsPage sendMailGoDraftsAgain(){

        driver.switchTo().defaultContent();
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("document.querySelector(\"div#b-toolbar__right div[data-name='send']\").click()");

        //Enter Drafts again
        emailDraftsEnter2.click();

        return new DraftsPage(driver);}

}
