package by.epam.atm.lecture9.tests;

import by.epam.atm.lecture9.bo.Account;
import by.epam.atm.lecture9.bo.Letter;
import by.epam.atm.lecture9.pages.*;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import by.epam.atm.patterns.singleton.WebDriverSingleton;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import by.epam.atm.utiles.CustomLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static by.epam.atm.patterns.singleton.WebDriverType.CHROME;

public class MailWebDriverTest {

    private static final String URL = "https://mail.ru";

    private static WebDriverDecorator driver;
    private LoggedInPage login;
    private DraftsPage drafts;
    private DraftMailPage savedDraft;
    private SentPage sent;

    @BeforeClass(description = "Start browser")
    public void startBrowser() throws UnknownDriverTypeException {
        WebDriver instance = WebDriverSingleton.getWebDriverInstance(CHROME);
        driver = new WebDriverDecorator(instance);
        driver.get(URL);
        WebDriverWait explicitWait = CustomWaiter.getDriverWaitInstance(driver,3);
    }

    @Test(description = "Login")
    public void login() {
        login = new LoginPage(driver).loginToMail(new Account());
        boolean loginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(loginSuccessful, "Login was not successful");
        CustomLogger.info("Login is successful");
    }

    @Test(description = "Creation of an email, saving it to Drafts, check that the mail is saved", dependsOnMethods = {
            "login"})
    public void createSaveMail() throws UnknownDriverTypeException {
        drafts = login.createMail().createAndSaveMail(new Letter());
        boolean mailSaved = drafts.isMaleSaved();
        Assert.assertTrue(mailSaved, "The draft mail is not present in Drafts");
        CustomLogger.info("The draft mail is present in Drafts");
    }

    @Test(description = "Check if the addressee of the saved mail is correct", dependsOnMethods = {
            "createSaveMail"})
    public void checkAddressee() {
        boolean addresseeCorrect = drafts.isAddresseeCorrect();
        Assert.assertTrue(addresseeCorrect, "the addressee is wrong");
        CustomLogger.info("The addressee is correct");
    }

    @Test(description = "Check if the body message of the saved mail is correct", dependsOnMethods = {
            "checkAddressee"})
    public void checkMessage() {
        savedDraft = drafts.openDraft();
        boolean bodyCorrect = savedDraft.isBodyCorrect();
        Assert.assertTrue(bodyCorrect, "the body message is wrong");
        CustomLogger.info("The body message is correct");
    }

    @Test(description = "Send the email, verify the mail has disappeared from ‘Draft’ folder", dependsOnMethods = {"checkMessage"})
    public void sendMail() {
        boolean draftDisappears = savedDraft.sendMailGoDraftsAgain().isMailPresent();
        Assert.assertFalse(draftDisappears, "The draft mail is still present in Drafts");
        CustomLogger.info("The draft mail is not present in Drafts anymore");}

    @Test(description = "Verify that the mail is present in Sent", dependsOnMethods = {"sendMail"})
    public void sentMail(){
        boolean mailSent = drafts.goToSent().isMaleSent();
        Assert.assertTrue(mailSent, "The mail is not present in Sent");
        CustomLogger.info("The mail is present in Sent");
    }

    @Test(description = "Remove the mail, check no sent mails are left", dependsOnMethods = {"sentMail"})
    public void noMailsLeft() {
        sent = new SentPage(driver);
        sent.removeMailFromSent();
        boolean sentEmailRemoved = sent.isMailRemoved();
        Assert.assertFalse(sentEmailRemoved, "The sent mail is still present in Sent");
        CustomLogger.info("The sent mail is not present in Sent anymore");
    }

    @AfterMethod
    public void ifTestFailed(ITestResult testResult){
        if (testResult.getStatus() == ITestResult.FAILURE) {
         driver.makeScreenshotOnFailure(testResult);
         CustomLogger.errorMessage("The test '" + testResult.getName() + "' failed");
        }
    }

    @AfterClass(description = "Remove sent emails, log off and close browser")
    public void logOffStopBrowser() {
        sent.logout();
        driver.quit();
        CustomLogger.info("Browser was successfully quited.");
    }
}
