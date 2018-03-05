package by.epam.atm.patterns.decorator.driver_decorator;

import by.epam.atm.patterns.staticfactory.CustomWaiter;
import by.epam.atm.utiles.CustomLogger;
import by.epam.atm.utiles.HighlightElement;
import by.epam.atm.utiles.MakeScreenshot;
import by.epam.atm.utiles.MakeScreenshotOnFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
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
        CustomLogger.info(String.format("Finding element: %s", by.toString()));
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        CustomLogger.info(String.format("Finding element: %s", by.toString()));
        return driver.findElement(by);
    }

    public void click(WebElement element){
        HighlightElement.highlightElement(driver, element);
        MakeScreenshot.makeScreenshot(driver);
        HighlightElement.unHighlightElement(driver, element);
        CustomLogger.info (String.format("Clicking element: '" + element.getText() + "' %s" , element.toString()));
        element.click();
    }

    public void type(WebElement element, String text){
        HighlightElement.highlightElement(driver, element);
        element.sendKeys(text);
        CustomLogger.info (String.format("Typing text into element: '" + element.getText() + "' %s" , element.toString()));
        HighlightElement.unHighlightElement(driver, element);
    }

    public void scriptExecutor(String script){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript(script);
    }

    public Actions createAction(){
        Actions action = new Actions(driver);
        return action;
    }

    public void makeScreenshotOnFailure(ITestResult testResult){
        MakeScreenshotOnFailure.makeScreenshot(testResult, driver);
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
