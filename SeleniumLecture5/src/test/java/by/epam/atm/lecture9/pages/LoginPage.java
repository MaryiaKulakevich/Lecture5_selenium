package by.epam.atm.lecture9.pages;

import by.epam.atm.lecture9.bo.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "mailbox:login")
    private WebElement searchLogin;

    @FindBy(id = "mailbox:password")
    private WebElement searchPassword;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement clickEnterBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoggedInPage loginToMail(Account user) {
        //Enter login
        searchLogin.sendKeys(user.getLogin());

        //Enter password
        searchPassword.sendKeys(user.getPassword());

        //Click Enter button
        clickEnterBtn.click();

        return new LoggedInPage(driver);
    }

}
