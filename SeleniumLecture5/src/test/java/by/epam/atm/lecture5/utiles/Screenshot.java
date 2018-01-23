package by.epam.atm.lecture5.utiles;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void makeScreenshot(WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/test-output/screenshot"+System.currentTimeMillis()+".png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
