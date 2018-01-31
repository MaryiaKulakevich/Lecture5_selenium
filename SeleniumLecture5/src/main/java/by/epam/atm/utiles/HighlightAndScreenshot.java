package by.epam.atm.utiles;

import org.openqa.selenium.*;

public class HighlightAndScreenshot {

    public static void highlightElement(WebElement element, WebDriver driver) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        MakeScreenshot.makeScreenshot(driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }
}
