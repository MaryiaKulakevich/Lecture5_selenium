package by.epam.atm.lecture10.steps;

import by.epam.atm.lecture10.bo.Account;
import by.epam.atm.lecture10.pages.LoggedInPage;
import by.epam.atm.lecture10.pages.LoginPage;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import by.epam.atm.patterns.singleton.WebDriverSingleton;
import by.epam.atm.patterns.singleton.WebDriverType;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static by.epam.atm.patterns.singleton.WebDriverType.CHROME;

public class MailLoginSteps {

    private static WebDriver driver;
    private static final String URL = "https://mail.ru";
    private LoggedInPage login;
    
    @Given("^user navigates to mail home page$")
    public void userNavigatesToMailHomePage() throws UnknownDriverTypeException {
        driver = WebDriverSingleton.getWebDriverInstance(CHROME);
        driver.get(URL);
    }

    @When("^user enters credentials and clicks enter button$")
    public void userEntersCredentialsAndClicksEnterButton(){
        login = new LoginPage(driver).loginToMail(new Account());
    }

    @Then("^user is logged in to his account$")
    public void userIsLoggedInToHisAccount(){
        boolean loginSuccessful = login.isLoginSuccessful();
        Assert.assertTrue(loginSuccessful, "Login was not successful");
        System.out.println("Login is successful");
    }
}
