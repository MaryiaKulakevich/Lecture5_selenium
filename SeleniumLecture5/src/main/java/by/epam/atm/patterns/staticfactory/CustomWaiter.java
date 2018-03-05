package by.epam.atm.patterns.staticfactory;

import by.epam.atm.utiles.CustomLogger;
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
        CustomLogger.debug(String.format("Getting an instance of WebDriverWait and setting explicit timeout to %s seconds", TIME/number));
        return explicitWait;
    }

    public static void waitUntilAllVisible(List<WebElement> elements){
        explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        CustomLogger.debug(String.format("Waiting until all elements are visible: %s", elements.toString()));
    }

    public static void waitUntilAllInvisible(List<WebElement> elements){
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
        CustomLogger.debug(String.format("Waiting until all elements are invisible: %s", elements.toString()));
    }


    public static void waitUntilClickable(WebElement element){
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        CustomLogger.debug(String.format("Waiting until element is clickable: '" + element.getText() + "' %s" , element.toString()));
    }



    public static void waitUntilVisible(WebElement element){
        explicitWait.until(ExpectedConditions.visibilityOf(element));
        CustomLogger.debug(String.format("Waiting until element is visible: '" + element.getText() + "' %s" , element.toString()));
    }

    public static void waitImplicitly(WebDriver driver, long time){
     driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
     CustomLogger.debug(String.format("Setting implicit timeout to %s seconds", time));

    }

}
