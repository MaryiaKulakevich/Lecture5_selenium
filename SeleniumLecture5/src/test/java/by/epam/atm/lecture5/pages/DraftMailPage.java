package by.epam.atm.lecture5.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DraftMailPage extends AbstractPage {
    @FindBy(xpath="//div[contains(text(),'WebDriver is a remote control interface')]")
    private List<WebElement> checkBody;

//    @FindBy(xpath="//div[@class='b-sticky']//div[@data-name='send']")
//    private List<WebElement> sendEmailBtn;

    @FindBy(xpath="//div[@id='LEGO']//a[@href='/messages/drafts/']")
    private WebElement emailDraftsEnter2;

    public DraftMailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBodyCorrect() {
        driver.switchTo().frame(0);
        return isElementPresent(checkBody);
    }

    public DraftsPage sendMailGoDraftsAgain(){

        driver.switchTo().defaultContent();
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("document.querySelector(\"div#b-toolbar__right div[data-name='send']\").click()");

        // Sending email
//        explicitTimeout().until(ExpectedConditions.visibilityOfAllElements(sendEmailBtn));
//        sendEmailBtn.get(0).click();

        //Enter Drafts again
        emailDraftsEnter2.click();

        return new DraftsPage(driver);}

}
