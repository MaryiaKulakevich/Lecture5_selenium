package by.epam.atm.patterns.decorator.driver_decorator;

import by.epam.atm.utiles.HighlightAndScreenshot;
import by.epam.atm.utiles.MakeScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import java.util.List;
import java.util.Set;

public class WebDriverDecorator implements WebDriver{

    protected WebDriver driver;

    public WebDriverDecorator (WebDriver driver){
        this.driver = driver;
    }

    public void get(String s) {
        driver.get(s);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by)  {
        Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()),
                true);
        MakeScreenshot.makeScreenshot(driver);
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        Reporter.log(String.format("Finding element: %s, current URL: '%s'", by.toString(), driver.getCurrentUrl()),
                true);
        MakeScreenshot.makeScreenshot(driver);
        return driver.findElement(by);
    }

    public void scriptExecutor(String script){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript(script);
    }

    public Actions createAction(){
        Actions action = new Actions(driver);
        return action;
    }

    public void highlightElement(WebElement element) {
        HighlightAndScreenshot.highlightElement(element, driver);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public Options manage() {
        return driver.manage();
    }

}