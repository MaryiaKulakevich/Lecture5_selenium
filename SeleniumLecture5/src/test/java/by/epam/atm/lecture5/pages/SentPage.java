package by.epam.atm.lecture5.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SentPage extends AbstractPage {

    @FindBy(xpath="//a[@data-subject='lecture5 selenium']")
    private List<WebElement> sentMail;

//    @FindBy(xpath = "//div[@class='b-sticky']//div[@data-cache-key='500000_undefined_false']//div[@class='b-checkbox__box']" )
//    private WebElement selectAll;

//    @FindBy(xpath = "//div[@class='b-sticky']//div[@data-cache-key='500000_undefined_false']//div[@data-name ='remove']")
//    private List<WebElement> removeAll;

     @FindBy(xpath = "//div[@id='b-nav_folders']//a[@href='/messages/trash/']")
     private WebElement bin;

    @FindBy(id = "PH_logoutLink")
    private WebElement searchLogout;

    public SentPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMaleSent() { return isElementPresent(sentMail); }

    public boolean isMailRemoved() {
        explicitTimeout().until(ExpectedConditions.invisibilityOfAllElements(sentMail));
        return isElementPresent(sentMail);}

    public void removeMailFromSent(){

        new Actions(driver).dragAndDrop(sentMail.get(0), bin).build().perform();

        //Select all in Sent folder
//        selectAll.click();
//
//        //Remove All from Sent
//        explicitTimeout().until(ExpectedConditions.visibilityOfAllElements(removeAll));
//        removeAll.get(0).click();

    }

    public void logout(){
        //Log out
        searchLogout.click();
        System.out.println("Logout");
    }

}
