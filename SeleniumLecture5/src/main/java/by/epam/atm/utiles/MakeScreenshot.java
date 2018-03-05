package by.epam.atm.utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class MakeScreenshot {

    public static void makeScreenshot(WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath ="src/test/resources/test-output/screenshot"+System.currentTimeMillis()+".jpg";
            File copy = new File (screenshotPath);
            FileUtils.copyFile(scrFile, copy);
            CustomLogger.attach(screenshotPath, " Taking screenshot");

        } catch (IOException e) {
            CustomLogger.error ("Failed to take screenshot", e);
        }
    }
}
