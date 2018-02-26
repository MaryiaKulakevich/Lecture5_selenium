package by.epam.atm.lecture9.pages;

import by.epam.atm.patterns.staticfactory.CustomWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        CustomWaiter.waitUntilVisible(loginSuccessful);
        return isElementPresent(loginSuccessful);
    }

    public CreateMailPage createMail(){
        clickWriteEmailBtn.click();
        return new CreateMailPage(driver);
    }
}
