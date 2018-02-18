package by.epam.atm.lecture5;

import by.epam.atm.lecture5.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyWebDriverTest {

    private static final String URL = "https://mail.ru";
    private static final String LOGIN_NAME = "mentee2017_2";
    private static final String PASSWORD = "automation2017";
    private static final String TO = "uladzie@gmail.com";
    private static final String SUBJECT = "lecture5 selenium";
    private static final String BODY = "WebDriver is a remote control interface that enables introspection and control of user agents. It provides a platform- and language-neutral wire protocol as a way for out-of-process programs to remotely instruct the behaviour of web browsers";

    private WebDriver driver;
    private LoggedInPage login;
    private DraftsPage drafts;
    private DraftMailPage savedDraft;
    private WebDriverWait wait;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        // Setting implicit timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize browser window
        driver.manage().window().maximize();

        // Open the web page
        driver.get(URL);

        wait = new WebDriverWait(driver, 10);
    }

    @Test(description = "Login")
    public void login() throws InterruptedException {
        login = new LoginPage(driver, wait).loginToMail(LOGIN_NAME, PASSWORD);
        boolean loginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(loginSuccessful, "Login was not successful");
        System.out.println("Login is successful");
    }

    @Test(description = "Creation of an email and saving it to Drafts", dependsOnMethods = {
            "login"})
    public void createSaveMail() throws InterruptedException {
        drafts = login.createMail().createAndSaveMail(TO, SUBJECT, BODY);

        //Check availability of the draft
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
        Assert.assertTrue(bodyCorrect);
        System.out.println("The body is correct");
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

    @AfterClass(description = "Remove sent emails, log off and close browser")
    public void logOffStopBrowser() throws InterruptedException {

        new SentPage(driver, wait).removeAllAndLogOut();

        driver.quit();
        System.out.println("Browser was successfully quited.");
    }

}
