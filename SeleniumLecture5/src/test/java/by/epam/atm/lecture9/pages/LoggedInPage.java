package by.epam.atm.lecture9.pages;

import by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator;
import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoggedInPage extends AbstractPage{

    @FindBy(id="PH_user-email")
    private List<WebElement> loginSuccessful;

    @FindBy(xpath="//div[@class='b-sticky']//a[@data-name='compose']")
    private WebElement clickWriteEmailBtn;


    public LoggedInPage(WebDriverDecorator driver) {
        super(driver);
    }

    public boolean isLoginSuccessful() {
        CustomWaiter.waitUntilAllVisible(loginSuccessful);
        return isElementPresent(loginSuccessful);
    }

    public CreateMailPage createMail(){
        driver.click(clickWriteEmailBtn);
        return new CreateMailPage(driver);
    }
}
