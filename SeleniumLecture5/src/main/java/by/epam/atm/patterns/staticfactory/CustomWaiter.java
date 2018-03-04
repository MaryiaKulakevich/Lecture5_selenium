package by.epam.atm.patterns.staticfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomWaiter {

    private static WebDriverWait explicitWait;
    private static final long TIME =50;

    public static WebDriverWait getDriverWaitInstance(WebDriver driver, int number){
        if(explicitWait==null){
           explicitWait = new WebDriverWait(driver, TIME/number);
        }
        return explicitWait;
    }

    public static void waitUntilAllVisible(List<WebElement> elements){
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitUntilAllInvisible(List<WebElement> elements){
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }


    public static void waitUntilClickable(WebElement element){
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilVisible(WebElement element){
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitImplicitly(WebDriver driver, long time){
     driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);}

}
