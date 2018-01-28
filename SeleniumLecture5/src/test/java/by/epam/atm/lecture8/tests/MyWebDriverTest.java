package by.epam.atm.lecture8.tests;

import by.epam.atm.lecture8.bo.Account;
import by.epam.atm.lecture8.bo.Letter;
import by.epam.atm.lecture8.pages.*;
import by.epam.atm.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyWebDriverTest {

    private static final String URL = "https://mail.ru";

    private static WebDriver driver;
    private LoggedInPage login;
    private DraftsPage drafts;
    private DraftMailPage savedDraft;
    private SentPage sent;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver = WebDriverSingleton.getWebDriverInstance();

        // Setting standard timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open the web page
        driver.get(URL);
    }

    @Test(description = "Login")
    public void login() throws InterruptedException {
        login = new LoginPage(driver).loginToMail(new Account());
        boolean loginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(loginSuccessful, "Login was not successful");
        System.out.println("Login is successful");
    }

    @Test(description = "Creation of an email and saving it to Drafts", dependsOnMethods = {
            "login"})
    public void createSaveMail() throws InterruptedException {
        drafts = login.createMail().createAndSaveMail(new Letter());
        boolean mailSaved = drafts.isMaleSaved();
        Assert.assertTrue(mailSaved, "The draft mail is not present in Drafts");
        System.out.println("The draft mail is present in Drafts");

        //Check if the addressee is correct
        boolean addresseeCorrect = drafts.isAddresseeCorrect();
        Assert.assertTrue(addresseeCorrect, "the addressee is wrong");
        System.out.println("The addressee is correct");

        //Check if the subject of the draft is correct
        boolean subjectCorrect = drafts.isSubjectCorrect();
        Assert.assertTrue(subjectCorrect, "the subject is wrong");
        System.out.println("The subject is correct");

        //Check if the message body of the draft is correct
        savedDraft = drafts.openDraft();
        boolean bodyCorrect = savedDraft.isBodyCorrect();
        Assert.assertTrue(bodyCorrect,"the body message is wrong" );
        System.out.println("The body message is correct");
    }

    @Test(description = "Send the email, verify that the email is sent", dependsOnMethods = {"createSaveMail"})
    public void sendMail() throws InterruptedException {

        //Verify that the mail has disappeared from ‘Draft’ folder
        boolean draftDisappears = savedDraft.sendMailGoDraftsAgain().isMailPresent();
        Assert.assertFalse(draftDisappears, "The draft mail is still present in Drafts");
        System.out.println("The draft mail is not present in Drafts anymore");

        //verify that the mail is present in Sent
        boolean mailSent = drafts.goToSent().isMaleSent();
        Assert.assertTrue(mailSent, "The mail is not present in Sent");
        System.out.println("The mail is present in Sent");
    }

    @Test(description = "Check no sent emails are left", dependsOnMethods = {"sendMail"})
    public void noMailsLeft() throws InterruptedException {

        //remove the mail from Sent
        sent = new SentPage(driver);
        sent.removeMailFromSent();

        //Verify that the mail has been removed from ‘Sent’ folder
        boolean sentEmailRemoved = sent.isMailRemoved();
        Assert.assertFalse(sentEmailRemoved, "The sent mail is still present in Sent");
        System.out.println("The sent mail is not present in Sent anymore");
    }

    @AfterClass(description = "Remove sent emails, log off and close browser")
    public void logOffStopBrowser() throws InterruptedException {
        sent.logout();
        driver.quit();
        System.out.println("Browser was successfully quited.");
    }
}
