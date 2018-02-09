package by.epam.atm.lecture10.pages;

import by.epam.atm.lecture10.bo.Letter;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SentPage extends AbstractPage {

//    @FindBy(xpath = "//div[@data-cache-key='500000_undefined_false']//a[@data-subject='lecture10 selenium']")
//    private List<WebElement> sentMail;

    /**
     * the locator is made dynamic
     */
    private String CHECK_MAIL_AVAILABILITY = String.format("//div[@data-cache-key='500000_undefined_false']//a[@data-subject='%s']", new Letter().getSubject());
    private List<WebElement> sentMail;

    @FindBy(xpath = "//div[@id='b-nav_folders']//a[@href='/messages/trash/']")
    private WebElement bin;

    @FindBy(id = "PH_logoutLink")
    private WebElement searchLogout;

    @FindBy(xpath = "//div[@data-id='500001']//span[@class='b-nav__item__text']")
    private WebElement emailDraftsEnter;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSent() {
        sentMail=driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
        ((WebDriverDecorator)driver).highlightElement(sentMail.get(0));
        return isElementPresent(sentMail);
    }

    public void removeMailFromSent() {
         sentMail=driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
        ((WebDriverDecorator)driver).createAction().dragAndDrop(sentMail.get(0), bin).build().perform();
    }

    public boolean isMailRemoved() {
        sentMail=driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
        CustomWaiter.waitUntilInvisible(driver, 10, sentMail);
        return isElementPresent(sentMail);
    }

    /**
     * the method was added to navigate to Drafts folder from Sent folder
     */
    public DraftsPage goToDrafts(){
        emailDraftsEnter.click();
        return new DraftsPage(driver);
    }

    public void logout() {
        //Log out
        searchLogout.click();
        System.out.println("Logout");
    }

}
