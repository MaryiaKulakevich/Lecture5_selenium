package by.epam.atm.lecture9.pages;

import by.epam.atm.lecture9.bo.Account;
import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
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

    public LoginPage(WebDriverDecorator driver) {
        super(driver);
    }

    public LoggedInPage loginToMail(Account user) {
       //Enter login
       driver.type(searchLogin, user.getLogin() );

       //Enter password
       driver.type(searchPassword, user.getPassword());

       //Click Enter button
       driver.click(clickEnterBtn);

       return new LoggedInPage(driver);
    }

}
