package by.epam.atm.lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyWebDriverTest {

    private static final String MAIL_LOGIN_FIELD = "mailbox:login";
    private static final String LOGIN_NAME = "mentee2017_2";
    private static final String MAIL_PASSWORD_FIELD = "mailbox:password";
    private static final String PASSWORD = "automation2017";
    private static final String ENTER_BUTTON = "//input[@value='Войти']";
    private static final String ID_LOGIN_SUCCESSFUL = "PH_user-email";
    private static final String WRITE_MAIL_BTN = "//div[@class='b-sticky']//a[@data-name='compose']";
    private static final String WRITE_TO_FIELD = "//textarea[@tabindex='4']";
    private static final String SUBJECT_FIELD = "div.compose-head__field>input.b-input";
    private static final String BODY_FIELD = "//body[@class='mceContentBody compose2']";
    private static final String SAVE_BTN = "//div[@class='b-sticky']//div[@data-name='saveDraft']";
    private static final String MAIL_SAVED = "//div[@class='b-sticky']//a[@href='/messages/drafts']";
    private static final String DRAFTS_FOLDER_LINK = "//div[@data-id='500001']//span[@class='b-nav__item__text']";
    private static final String CHECK_MAIL_AVAILABILITY = "//a[@data-subject='lecture5 selenium']";
    private static final String CHECK_ADDRESSEE = "//div[text()='uladzie@gmail.com']";
    private static final String CHECK_SUBJECT = "//div[text()='lecture5 selenium']";
    private static final String CHECK_MAIL_BODY = "//div[contains(text(),'WebDriver is a remote control interface')]";
    private static final String SEND_MAIL_BUTTON = "//div[@class='b-sticky']//div[@data-name='send']";
    private static final String DRAFTS2_LINK = "//div[@id='LEGO']//a[@href='/messages/drafts/']";
    private static final String SENT_FOLDER_LINK = "//div[@data-id='500000']/a[@href='/messages/sent/']";
    private static final String SELECT_ALL_CHECKBOX = "//div[@class='b-sticky']//div[@data-cache-key='500000_undefined_false']//div[@class='b-checkbox__box']";
    private static final String REMOVE_ALL = "//div[@class='b-sticky']//div[@data-cache-key='500000_undefined_false']//div[@data-name ='remove']";
    private static final String LOGOUT = "PH_logoutLink";
    private WebDriver driver;
    private WebElement checkSubject;
    private WebElement savedEmail;
    private WebElement searchLogin;
    private WebElement searchPassword;
    private WebElement clickEnterBtn;
    private WebElement loginSuccessful;
    private WebElement clickWriteEmailBtn;
    private WebElement emailToField;
    private WebElement emailSubjectField;
    private WebElement emailBodyField;
    private WebElement emailSaveBtn;
    private WebElement emailDraftsEnter;
    private WebElement checkAddressee;
    private WebElement checkMailBody;
    private WebElement sendEmailBtn;
    private WebElement emailDraftsEnter2;
    private WebElement clickSent;
    private WebElement sentEmail;
    private WebElement selectAll;
    private WebElement removeAll;
    private WebElement searchLogout;
    private WebDriverWait explicitTimeout;


    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();

        // Setting standard timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Maximize browser window
        driver.manage().window().maximize();

        // Open the web page
        driver.get("https://mail.ru");

        explicitTimeout = new WebDriverWait(driver, 10);


    }

    @Test(description = "Login")
    public void login() throws InterruptedException {
        //Enter login
        searchLogin = driver.findElement(By.id(MAIL_LOGIN_FIELD));
        searchLogin.sendKeys(LOGIN_NAME);

        //Enter password
        searchPassword = driver.findElement(By.id(MAIL_PASSWORD_FIELD));
        searchPassword.sendKeys(PASSWORD);

        //Click Enter button
        clickEnterBtn = driver.findElement(By.xpath(ENTER_BUTTON));
        clickEnterBtn.click();

        //setting explicit timeout
        explicitTimeout.until(ExpectedConditions.visibilityOfElementLocated(By.id(ID_LOGIN_SUCCESSFUL)));

        loginSuccessful = driver.findElement(By.id(ID_LOGIN_SUCCESSFUL));
        Assert.assertTrue(loginSuccessful.isDisplayed(), "Login was not successful");
    }

    @Test(description = "Creation of an email and saving it to Drafts", dependsOnMethods = {
            "login"})
    public void createSaveMail() throws InterruptedException {

        //Create new email
        clickWriteEmailBtn = driver.findElement(By.xpath(WRITE_MAIL_BTN));
        clickWriteEmailBtn.click();

        //Enter To value
        emailToField = driver.findElement(By.xpath(WRITE_TO_FIELD));
        emailToField.sendKeys("uladzie@gmail.com");

        //Enter Subject value
        emailSubjectField = driver.findElement(By.cssSelector(SUBJECT_FIELD));
        emailSubjectField.sendKeys("lecture5 selenium");

        //Switch to the frame of Body
        driver.switchTo().frame(0);

        //Enter Body
        emailBodyField = driver.findElement(By.xpath(BODY_FIELD));
        emailBodyField.sendKeys("WebDriver is a remote control interface that enables introspection and control of user agents. It provides a platform- and language-neutral wire protocol as a way for out-of-process programs to remotely instruct the behaviour of web browsers.\n");

        //return back to initial context
        driver.switchTo().defaultContent();

        //Save the email as a draft.
        emailSaveBtn = driver.findElement(By.xpath(SAVE_BTN));
        emailSaveBtn.click();

        //Wait until the mail is saved
        explicitTimeout.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MAIL_SAVED)));

        //Enter Drafts
        emailDraftsEnter = driver.findElement(By.xpath(DRAFTS_FOLDER_LINK));
        emailDraftsEnter.click();

        //Check availability of the draft
        savedEmail = driver.findElement(By.xpath(CHECK_MAIL_AVAILABILITY));
        Assert.assertTrue(savedEmail.isDisplayed(), "The draft mail is not present in Drafts");

        //Check if the addressee and subject of the draft are correct
        checkAddressee = driver.findElement(By.xpath(CHECK_ADDRESSEE));
        Assert.assertTrue(checkAddressee.isDisplayed(), "the addressee is wrong");

        checkSubject = driver.findElement(By.xpath(CHECK_SUBJECT));
        Assert.assertTrue(checkSubject.isDisplayed(), "the subject is wrong");

        //Open the draft
        checkSubject.click();

        //Check if the message body of the draft is correct
        driver.switchTo().frame(0);
        checkMailBody = driver.findElement(By.xpath(CHECK_MAIL_BODY));
        Assert.assertTrue(checkMailBody.isDisplayed());
        driver.switchTo().defaultContent();
    }

    @Test(description = "Send the email, verify that the email is sent", dependsOnMethods = {"createSaveMail"})
    public void sendMail() throws InterruptedException {

//      new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='b-sticky']//div[@data-name='send']")));
        // Sending email
        sendEmailBtn = driver.findElement(By.xpath(SEND_MAIL_BUTTON));
        sendEmailBtn.click();

        //Enter Drafts again
        emailDraftsEnter2 = driver.findElement(By.xpath(DRAFTS2_LINK));
        emailDraftsEnter2.click();

        //Verify, that the mail has disappeared from ‘Draft’ folder
        explicitTimeout.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CHECK_MAIL_AVAILABILITY)));
        Assert.assertTrue(driver.findElements(By.xpath("//a[@data-subject='lecture5 selenium']")).size() < 1, "The draft mail is still present in Drafts");

        //Enter 'Sent' folder
        clickSent = driver.findElement(By.xpath(SENT_FOLDER_LINK));
        clickSent.click();

        //Check availability of the email in Sent
        explicitTimeout.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CHECK_MAIL_AVAILABILITY)));
        sentEmail = driver.findElement(By.xpath(CHECK_MAIL_AVAILABILITY));
        Assert.assertTrue(sentEmail.isDisplayed());
    }

    @AfterClass(description = "Remove sent emails, log off and close browser")
    public void logOffStopBrowser() throws InterruptedException {

        //Select all in Sent folder
        selectAll = driver.findElement(By.xpath(SELECT_ALL_CHECKBOX));
        selectAll.click();

        //Remove All from Sent
        explicitTimeout.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REMOVE_ALL)));
        removeAll = driver.findElement(By.xpath(REMOVE_ALL));
        removeAll.click();

        //Log out
        searchLogout = driver.findElement(By.id(LOGOUT));
        searchLogout.click();

        driver.quit();
        System.out.println("Browser was successfully quited.");
    }

}
