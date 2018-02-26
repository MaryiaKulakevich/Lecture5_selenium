package by.epam.atm.lecture10.pages;

import by.epam.atm.lecture10.bo.Letter;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraftsPage extends AbstractPage {

//    @FindBy(xpath = "//a[@data-subject='lecture9 selenium']")
//    private List<WebElement> savedMail;

    /**
     * the locator is made dynamic
     */
    private String CHECK_MAIL_AVAILABILITY = String.format("//a[@data-subject='%s']", new Letter().getSubject());
    private List<WebElement> savedMail;

    @FindBy(xpath = "//div[text()='mentee2017@mail.ru']")
    private List<WebElement> checkAddressee;

    @FindBy(xpath = "//div[@data-id='500000']/a[@href='/messages/sent/']")
    private WebElement clickSent;

    @FindBy(xpath="//div[@class='b-sticky js-not-sticky']//div[@data-cache-key='500001_undefined_false']//div[@class='b-checkbox__box']")
    private WebElement checkBoxAll;

    @FindBy(xpath = "//div[@id='b-nav_folders']//a[@href='/messages/trash/']")
    private WebElement bin;

    @FindBy(id = "PH_logoutLink")
    private WebElement searchLogout;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSaved() {
        savedMail=driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
        return isElementPresent(savedMail);
    }

    public boolean isAddresseeCorrect() {
        return isElementPresent(checkAddressee);
    }

    public DraftMailPage openDraft() {
        savedMail=driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
        savedMail.get(0).click();
        return new DraftMailPage(driver);
    }

    public boolean isMailPresent() {
        savedMail=driver.findElements(By.xpath(CHECK_MAIL_AVAILABILITY));
        CustomWaiter.waitUntilInvisible(savedMail);
        return isElementPresent(savedMail);
    }

    public SentPage goToSent() {
        clickSent.click();
        return new SentPage(driver);
    }

    /**
     * The method is added to remove mails from Drafts
     * if more than one mail with different subject was saved
     * See Scenario Outline: Create a mail, Examples
     */
    public void removeFromDrafts(){
        if(isElementPresent(checkAddressee)){
        checkBoxAll.click();
        ((WebDriverDecorator)driver).createAction().dragAndDrop(checkAddressee.get(0), bin).build().perform();}
        else{
            System.out.println("No mails to remove");
        }
    }

    /**
     * Verification of whether mails were removed from Drafts
     */
   public boolean isNotRemoved(){
       return isElementPresent(checkAddressee);
   }

    /**
     * Make logout from Drafts page
     */
    public void logout() {
        //Log out
        searchLogout.click();
        System.out.println("Logout");
    }

}
