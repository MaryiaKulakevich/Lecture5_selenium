package by.epam.atm.lecture8.utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class HighlightAndScreenshot {

    public static void highlightElement(WebElement element, WebDriver driver) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        makeScreenshot(driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public static void makeScreenshot(WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/test-output/screenshot"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
