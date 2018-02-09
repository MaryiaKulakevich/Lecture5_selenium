package by.epam.atm.lecture10.steps;

import by.epam.atm.lecture10.bo.Letter;
import by.epam.atm.lecture10.pages.CreateMailPage;
import by.epam.atm.lecture10.pages.DraftsPage;
import by.epam.atm.lecture10.pages.LoggedInPage;
import by.epam.atm.lecture10.tests.MailDriverCucumberTestNgTest;
import by.epam.atm.patterns.singleton.UnknownDriverTypeException;
import by.epam.atm.patterns.singleton.WebDriverSingleton;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static by.epam.atm.patterns.singleton.WebDriverType.CHROME;

public class CreateMailSteps extends MailDriverCucumberTestNgTest {

    private CreateMailPage mail;
    private DraftsPage drafts;

    @Given("^user creates a new mail$")
    public void userCreatesANewMail() throws UnknownDriverTypeException {
        mail = new LoggedInPage(driver).createMail();
    }

    @When("^user fills in addressee, \"([^\"]*)\", body and keys CTRL_S in$")
    public void userFillsInAddresseeBodyAndKeysCTRL_SIn(String subject){
       Letter.setSubject(subject);
       drafts = mail.createAndSaveMail(new Letter());
    }

    @Then("^the mail is saved in Drafts$")
    public void theMailIsSavedInDrafts() {
        boolean mailSaved = drafts.isMaleSaved();
        Assert.assertTrue(mailSaved, "The draft mail is not present in Drafts");
        System.out.println("The draft mail is present in Drafts");
    }

    @And("^addressee is correct$")
    public void addresseeIsCorrect() {
        boolean addresseeCorrect = drafts.isAddresseeCorrect();
        Assert.assertTrue(addresseeCorrect, "the addressee is wrong");
        System.out.println("The addressee is correct");
    }

}
