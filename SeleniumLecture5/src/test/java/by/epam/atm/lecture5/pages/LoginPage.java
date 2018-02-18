package by.epam.atm.lecture5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private WebElement searchLogin;

    @FindBy(id = "mailbox:password")
    private WebElement searchPassword;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement clickEnterBtn;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LoggedInPage loginToMail(String userName, String password) {
        //Enter login
        searchLogin.sendKeys(userName);

        //Enter password
        searchPassword.sendKeys(password);

        //Click Enter button
        clickEnterBtn.click();

        return new LoggedInPage(driver, wait);
    }

}
