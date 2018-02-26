package by.epam.atm.lecture10.tests;

import by.epam.atm.lecture10.bo.Account;
import by.epam.atm.lecture10.bo.Letter;
import by.epam.atm.lecture10.pages.*;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import by.epam.atm.patterns.singleton.WebDriverSingleton;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static by.epam.atm.patterns.singleton.WebDriverType.CHROME;

public class MailWebDriverTest {

    private static final String URL = "https://mail.ru";
    private static final long TIME = 30;
    private static WebDriver driver;
    private static WebDriverWait explicitWait;
    private LoggedInPage login;
    private DraftsPage drafts;
    private DraftMailPage savedDraft;
    private SentPage sent;

    @BeforeClass(description = "Start browser")
    public void startBrowser() throws UnknownDriverTypeException {
        driver = WebDriverSingleton.getWebDriverInstance(CHROME);
        driver = new WebDriverDecorator(driver);
        explicitWait = CustomWaiter.getDriverWaitInstance(driver, TIME/2);
        driver.get(URL);
    }

    @Test(description = "Login")
    public void login() {
        login = new LoginPage(driver).loginToMail(new Account());
        boolean loginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(loginSuccessful, "Login was not successful");
        System.out.println("Login is successful");
    }

    @Test(description = "Creation of an email, saving it to Drafts, check that the mail is saved", dependsOnMethods = {
            "login"})
    public void createSaveMail(){
        drafts = login.createMail().createAndSaveMail(new Letter());
        boolean mailSaved = drafts.isMaleSaved();
        Assert.assertTrue(mailSaved, "The draft mail is not present in Drafts");
        System.out.println("The draft mail is present in Drafts");
    }

    @Test(description = "Check if the addressee of the saved mail is correct", dependsOnMethods = {
            "createSaveMail"})
    public void checkAddressee() {
        boolean addresseeCorrect = drafts.isAddresseeCorrect();
        Assert.assertTrue(addresseeCorrect, "the addressee is wrong");
        System.out.println("The addressee is correct");
    }

    @Test(description = "Check if the body message of the saved mail is correct", dependsOnMethods = {
            "checkAddressee"})
    public void checkMessage() {
        savedDraft = drafts.openDraft();
        boolean bodyCorrect = savedDraft.isBodyCorrect();
        Assert.assertTrue(bodyCorrect, "the body message is wrong");
        System.out.println("The body message is correct");
    }

    @Test(description = "Send the email, verify the mail has disappeared from ‘Draft’ folder", dependsOnMethods = {"checkMessage"})
    public void sendMail() {
        boolean draftDisappears = savedDraft.sendMailGoDraftsAgain().isMailPresent();
        Assert.assertFalse(draftDisappears, "The draft mail is still present in Drafts");
        System.out.println("The draft mail is not present in Drafts anymore");}

    @Test(description = "Verify that the mail is present in Sent", dependsOnMethods = {"sendMail"})
    public void sentMail(){
        boolean mailSent = drafts.goToSent().isMaleSent();
        Assert.assertTrue(mailSent, "The mail is not present in Sent");
        System.out.println("The mail is present in Sent");
    }

    @Test(description = "Remove the mail, check no sent mails are left", dependsOnMethods = {"sentMail"})
    public void noMailsLeft() {
        sent = new SentPage(driver);
        sent.removeMailFromSent();
        boolean sentEmailRemoved = sent.isMailRemoved();
        Assert.assertFalse(sentEmailRemoved, "The sent mail is still present in Sent");
        System.out.println("The sent mail is not present in Sent anymore");
    }

    @AfterClass(description = "Log out and close browser")
    public void logOffStopBrowser() {
        sent.logout();
        driver.quit();
        System.out.println("Browser was successfully quited.");
    }
}
