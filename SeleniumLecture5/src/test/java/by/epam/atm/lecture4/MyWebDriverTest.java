package by.epam.atm.lecture4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MyWebDriverTest {

    private WebDriver driver;
    private WebElement checkSubject;

    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "e:\\ATP\\ChromeWebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        // Open the web page
        driver.get("https://mail.ru");

        // setting standard timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(description = "Login")
    public void login() throws InterruptedException {
        //Enter login
        WebElement searchLogin = driver.findElement(By.id("mailbox:login"));
        searchLogin.sendKeys("mentee2017");

        //Enter password
        WebElement searchPassword = driver.findElement(By.id("mailbox:password"));
        searchPassword.sendKeys("automation2017");

        //Click Enter button
        WebElement clickEnterBtn = driver.findElement(By.xpath("//input[@value='Войти']"));
        clickEnterBtn.click();

        //setting explicit timeout
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("PH_user-email")));

        WebElement loginSuccessful = driver.findElement(By.id("PH_user-email"));
        Assert.assertTrue(loginSuccessful.isDisplayed(), "Login was not successful");
    }

    @Test(description = "Creation of an email and saving it to Drafts", dependsOnMethods = {
            "login"})
    public void createMail() throws InterruptedException {

        //Create new email
        WebElement clickWriteEmailBtn = driver.findElement(By.xpath("//div[@class='b-sticky']//a[@data-name='compose']"));
        clickWriteEmailBtn.click();

        //Enter To value
        WebElement emailToField = driver.findElement(By.xpath("//textarea[@tabindex='4']"));
        emailToField.sendKeys("uladzie@gmail.com");

        //Enter Subject value
        WebElement emailSubjectField = driver.findElement(By.cssSelector("div.compose-head__field>input.b-input"));
        emailSubjectField.sendKeys("lecture5 selenium");

        //Switch to the frame of Body
        driver.switchTo().frame(0);

        //Enter Body
        WebElement emailBodyField = driver.findElement(By.xpath("//body[@class='mceContentBody compose2']"));
        emailBodyField.sendKeys("WebDriver is a remote control interface that enables introspection and control of user agents. It provides a platform- and language-neutral wire protocol as a way for out-of-process programs to remotely instruct the behaviour of web browsers.\n");

        //return back to initial context
        driver.switchTo().defaultContent();

        //Save the email as a draft.
        WebElement emailSaveBtn = driver.findElement(By.xpath("//div[@class='b-sticky']//div[@data-name='saveDraft']"));
        emailSaveBtn.click();

        //Wait until the mail is saved
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='b-sticky']//a[@href='/messages/drafts']")));

        //Enter Drafts
        WebElement emailDraftsEnter = driver.findElement(By.xpath("//div[@data-id='500001']//span[@class='b-nav__item__text']"));
        emailDraftsEnter.click();

        //Check availability of the draft
        WebElement savedEmail = driver.findElement(By.xpath("//a[@data-subject='lecture5 selenium']"));
        Assert.assertTrue(savedEmail.isDisplayed(), "The draft mail is not present in Drafts");

        //Check if the addressee and subject of the draft are correct
        WebElement checkAddressee = driver.findElement(By.xpath("//div[text()='uladzie@gmail.com']"));
        Assert.assertTrue(checkAddressee.isDisplayed(), "the addressee is wrong");

        checkSubject = driver.findElement(By.xpath("//div[text()='lecture5 selenium']"));
        Assert.assertTrue(checkSubject.isDisplayed(), "the subject is wrong");
    }

    @Test(description = "check message of the mail body", dependsOnMethods = {
            "createMail"})
    public void checkBody() throws InterruptedException{
        //Open the draft
        checkSubject.click();

        //Check if the message body of the draft is correct
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'WebDriver is a remote control interface')]")));
        WebElement checkMailBody = driver.findElement(By.xpath("//div[contains(text(),'WebDriver is a remote control interface')]"));
        Assert.assertTrue(checkMailBody.isDisplayed());

        driver.switchTo().defaultContent();
    }

    @Test(dependsOnMethods = {"checkBody"})
    public void sendMail() throws InterruptedException{
        new WebDriverWait(driver, 25).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='b-sticky']//div[@data-name='send']")));
        // Sending email
        WebElement sendEmailBtn = driver.findElement(By.xpath("//div[@class='b-sticky']//div[@data-name='send']"));
        sendEmailBtn.click();
    }

}
