package by.epam.atm.lecture5.utiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Timeout {

    private long time;

    public WebDriverWait explicitTimeout(WebDriver driver){
        return new WebDriverWait(driver, time);
    }

    public void setExplicitTimeout(long time){
        this.time = time;
    }
}
