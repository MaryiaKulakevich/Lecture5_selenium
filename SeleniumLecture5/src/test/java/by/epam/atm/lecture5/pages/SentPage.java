package by.epam.atm.lecture5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SentPage extends AbstractPage {

    @FindBy(xpath="//a[@data-subject='lecture5 selenium']")
    private List<WebElement> sentMail;

    @FindBy(xpath = "//div[@class='b-sticky']//div[@data-cache-key='500000_undefined_false']//div[@class='b-checkbox__box']" )
    private WebElement selectAll;

    @FindBy(xpath = "//div[@class='b-sticky']//div[@data-cache-key='500000_undefined_false']//div[@data-name ='remove']")
    private WebElement removeAll;

    @FindBy(id = "PH_logoutLink")
    private WebElement searchLogout;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSent() {
        return isElementPresent(sentMail);
    }

    public void removeAllAndLogOut(){
        //Select all in Sent folder
        selectAll.click();

        //Remove All from Sent
        removeAll.click();
        System.out.println("All mails from Sent are removed");

        //Log out
        searchLogout.click();
        System.out.println("Logout");
    }
}
