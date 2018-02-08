package by.epam.atm.lecture10.steps;

import by.epam.atm.lecture10.pages.DraftsPage;
import by.epam.atm.lecture10.pages.SentPage;
import by.epam.atm.lecture10.tests.MailDriverCucumberTestNgTest;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class RemoveFromDraftsSteps extends MailDriverCucumberTestNgTest {

    private DraftsPage drafts;

    @Given("^user returns to Drafts folder$")
    public void userReturnsToDraftsFolder(){
       drafts = new SentPage(driver).goToDrafts();
    }

    @When("^user clicks select all checkbox and drags and drops (\\d+) mails? to the bin$")
    public void removeToBin(int number) {
        drafts.removeFromDrafts();
    }

    @Then("^(\\d+) mails? removed$")
    public void mailIsRemoved(int number){
        boolean mailRemoved = drafts.isNotRemoved();
        Assert.assertFalse(mailRemoved,String.format("%s mail not removed", number));
        System.out.println(String.format("%s mail removed", number));
    }



}
