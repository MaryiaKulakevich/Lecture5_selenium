package by.epam.atm.utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomWaiter {

    private long time;
    private WebDriver driver;

    public CustomWaiter(WebDriver driver, long time){
        this.driver = driver;
        this.time=time;
    }

    public void waitImplicitly(WebDriver driver, long time){
     driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);}

    public void waitUntilVisible(List<WebElement> elements){
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntilInvisible(List<WebElement> elements){
        new WebDriverWait(driver, time).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public void waitUntilClickable(WebElement element){
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
    }

}
