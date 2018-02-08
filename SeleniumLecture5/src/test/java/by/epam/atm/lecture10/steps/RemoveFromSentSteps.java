package by.epam.atm.lecture10.steps;

import by.epam.atm.lecture10.pages.SentPage;
import by.epam.atm.lecture10.tests.MailDriverCucumberTestNgTest;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class RemoveFromSentSteps extends MailDriverCucumberTestNgTest{

    private SentPage sent;

    @Given("^user navigates to Sent folder$")
    public void userNavigatesToSentFolder() {
        sent = new SentPage(driver);
    }


    @When("^user drags and drops the mail to the bin$")
    public void userDragsAndDropsTheMailToTheBin() {
        sent.removeMailFromSent();
    }

    @Then("^the male is removed from Sent$")
    public void theMaleIsRemovedFromSent() {
        boolean sentEmailRemoved = sent.isMailRemoved();
        Assert.assertFalse(sentEmailRemoved, "The sent mail is still present in Sent");
        System.out.println("The sent mail is not present in Sent anymore");
    }
}
