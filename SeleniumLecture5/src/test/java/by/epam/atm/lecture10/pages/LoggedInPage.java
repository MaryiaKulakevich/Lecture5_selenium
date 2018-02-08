package by.epam.atm.lecture10.pages;

import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class LoggedInPage extends AbstractPage{

    @FindBy(id="PH_user-email")
    private List<WebElement> loginSuccessful;

    @FindBy(xpath="//div[@class='b-sticky']//a[@data-name='compose']")
    private WebElement clickWriteEmailBtn;

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginSuccessful() {
        CustomWaiter.waitUntilVisible(driver, 5, loginSuccessful);
        return isElementPresent(loginSuccessful);
    }

    public CreateMailPage createMail(){
        CustomWaiter.waitUntilClickable(driver,5, clickWriteEmailBtn);
        clickWriteEmailBtn.click();
        return new CreateMailPage(driver);
    }
}
