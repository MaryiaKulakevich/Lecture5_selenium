package by.epam.atm.patterns.staticfactory;

import by.epam.atm.patterns.singleton.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomWaiter {

    private static WebDriverWait explicitWait;
    private static final long TIME = 50;

    public static WebDriverWait getDriverWaitInstance(WebDriver driver, int number){
        if(explicitWait==null){
            explicitWait = new WebDriverWait(driver,TIME/number);
        }
        return explicitWait;
    }

    public static void waitUntilVisible(List<WebElement> elements){
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitUntilInvisible(List<WebElement> elements){
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void waitUntilClickable(WebElement element){
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitImplicitly(WebDriver driver, long time){
     driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);}
}
