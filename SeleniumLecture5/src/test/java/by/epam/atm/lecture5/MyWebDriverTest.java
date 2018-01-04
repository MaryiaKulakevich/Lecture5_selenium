package by.epam.atm.lecture5;

import by.epam.atm.lecture5.pages.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MyWebDriverTest {

    private static final String URL = "https://mail.ru";
    private static final String LOGIN_NAME = "mentee2017_2";
    private static final String PASSWORD = "automation2017";
    private static final String TO = "mentee2017@mail.ru";
    private static final String SUBJECT = "lecture5 selenium";
    private static final String BODY = "WebDriver is a remote control interface that enables introspection and control of user agents. It provides a platform- and language-neutral wire protocol as a way for out-of-process programs to remotely instruct the behaviour of web browsers";

    private static WebDriver driver;
    private LoggedInPage login;
    private DraftsPage drafts;
    private DraftMailPage savedDraft;
    private SentPage sent;

    public static WebDriver getDriver() {

        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private static void setDriver() {
//        Setting up Chrome driver and browser
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("platformName", Platform.WINDOWS);

        //Setting up Firefox driver and browser
//        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("start-maximized");
//        options.setCapability("platformName", Platform.WINDOWS);

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass(description = "Start browser")
    public void startBrowser() {

        driver = getDriver();

        // Open the web page
        driver.get(URL);

        // Setting standard timeout and maximizing window
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "Login")
    public void login() throws InterruptedException {
        login = new LoginPage(driver).loginToMail(LOGIN_NAME, PASSWORD);
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
