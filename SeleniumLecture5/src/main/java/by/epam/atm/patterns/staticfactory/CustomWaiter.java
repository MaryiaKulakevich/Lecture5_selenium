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

    public static void waitUntilVisible(WebDriver driver, long time, List<WebElement> elements){
        explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitUntilInvisible(WebDriver driver, long time, List<WebElement> elements){
        explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void waitUntilClickable(WebDriver driver, long time, WebElement element){
        explicitWait = new WebDriverWait(driver, time);;
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitImplicitly(WebDriver driver, long time){
     driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);}

}
