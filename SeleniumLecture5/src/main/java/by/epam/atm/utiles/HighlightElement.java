package by.epam.atm.utiles;

import org.openqa.selenium.*;

import java.util.List;

public class HighlightElement {

    public static void highlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='5px solid green'", element);
        CustomLogger.info("Highlighting element " + element.getText());
    }

    public static void unHighlightElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", element);
        CustomLogger.info("Unhighlighting element " + element.getText());
    }


}
