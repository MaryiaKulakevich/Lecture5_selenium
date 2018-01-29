package by.epam.atm.lecture8.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SentPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-subject='lecture8 selenium']")
    private List<WebElement> sentMail;

    @FindBy(xpath = "//div[@id='b-nav_folders']//a[@href='/messages/trash/']")
    private WebElement bin;

    @FindBy(id = "PH_logoutLink")
    private WebElement searchLogout;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSent() {
//        highlightElement(sentMail.get(0));
        return isElementPresent(sentMail);
    }

    public boolean isMailRemoved() {
        explicitTimeout().waitUntilInvisible(sentMail);
        return isElementPresent(sentMail);
    }

    public void removeMailFromSent() {
        new Actions(driver).dragAndDrop(sentMail.get(0), bin).build().perform();
    }

    public void logout() {
        //Log out
        searchLogout.click();
        System.out.println("Logout");
    }

}
