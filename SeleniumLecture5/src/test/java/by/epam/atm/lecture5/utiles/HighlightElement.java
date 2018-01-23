package by.epam.atm.lecture5.utiles;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {

    public static void highlightElement(WebElement element, WebDriver driver) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        Screenshot.makeScreenshot(driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }
}
