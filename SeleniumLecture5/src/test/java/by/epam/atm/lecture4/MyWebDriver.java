package by.epam.atm.lecture4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyWebDriver {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "e:\\ATP\\ChromeWebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Maximize browser window via options, just an example
        WebDriver driver = new ChromeDriver(options);

        // Open web page
        driver.get("https://mail.ru");

        // setting standard timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Enter login
        WebElement searchLogin = driver.findElement(By.id("mailbox:login"));
        searchLogin.sendKeys("mentee2017");

        //Enter password
        WebElement searchPassword = driver.findElement(By.id("mailbox:password"));
        searchPassword.sendKeys("automation2017");

        //Click Enter button
        WebElement clickEnterBtn = driver.findElement(By.xpath("//input[@value='Войти']"));
        clickEnterBtn.click();

        WebElement loginSuccessful = driver.findElement(By.id("PH_user-email"));

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

        //Check if the addressee and subject of the draft are correct
        WebElement checkAddressee = driver.findElement(By.xpath("//div[text()='uladzie@gmail.com']"));
        WebElement checkSubject = driver.findElement(By.xpath("//div[text()='lecture5 selenium']"));
        checkSubject.click();

        //Check if the message body of the draft is correct
        driver.switchTo().frame(0);

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'WebDriver is a remote control interface')]")));
        WebElement checkMailBody = driver.findElement(By.xpath("//div[contains(text(),'WebDriver is a remote control interface')]"));

        //return back to initial context
        driver.switchTo().defaultContent();

        // Sending email
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='b-sticky']//div[@data-name='send']")));
        WebElement sendEmailBtn = driver.findElement(By.xpath("//div[@class='b-sticky']//div[@data-name='send']"));
        sendEmailBtn.click();


//        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='LEGO']//a[@href='/messages/drafts/']")));

        //Enter Drafts again
//           WebElement emailDraftsEnter2 = driver.findElement(By.xpath("//div[@id='LEGO']//a[@href='/messages/drafts/']"));
//           emailDraftsEnter2.click();

//        WebElement searchLogout = driver.findElement(By.id("PH_logoutLink"));
//        searchLogout.click();
    }
}