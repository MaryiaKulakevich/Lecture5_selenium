package by.epam.atm.patterns.utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CustomWaiter {

    private long time;
    private WebDriver driver;

    public CustomWaiter(WebDriver driver, long time){
        this.driver = driver;
        this.time=time;
    }

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
