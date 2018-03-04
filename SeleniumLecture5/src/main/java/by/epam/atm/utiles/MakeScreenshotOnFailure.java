package by.epam.atm.utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class MakeScreenshotOnFailure {

    public static void makeScreenshot(ITestResult testResult, WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "src/test/test-output-failure/screenshot" + testResult.getName() + ".jpg";
            File copy = new File(screenshotPath);
            FileUtils.copyFile(scrFile, copy);
            CustomLogger.attach(screenshotPath, "Screenshot");
        } catch (IOException e) {
            CustomLogger.error("Failed to take screenshot", e);
        }
    }
}