package by.epam.atm.lecture10.steps;

import by.epam.atm.lecture10.pages.DraftMailPage;
import by.epam.atm.lecture10.pages.DraftsPage;
import by.epam.atm.lecture10.tests.MailDriverCucumberTestNgTest;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class DraftMailSteps extends MailDriverCucumberTestNgTest {

    private DraftsPage drafts;
    private DraftMailPage draft;

    @Given("^user navigates to Drafts folder$")
    public void userNavigatesToDraftsFolder(){
       drafts = new DraftsPage(driver);
    }

    @When("^user opens the saved mail$")
    public void userOpensTheSavedMail() {
      draft = drafts.openDraft();
    }

    @Then("^the message body is correct$")
    public void theMessageBodyIsCorrect()  {
        boolean bodyCorrect = draft.isBodyCorrect();
        Assert.assertTrue(bodyCorrect, "the body message is wrong");
        System.out.println("The body message is correct");
    }

    @When("^clicks send button$")
    public void clicksSendButton()  {
      drafts = draft.sendMailGoDraftsAgain();
    }

    @Then("^the mail disappears from Drafts$")
    public void theMailDisappearsFromDrafts()  {
        boolean draftDisappears = drafts.isMailPresent();
        Assert.assertFalse(draftDisappears, "The draft mail is still present in Drafts");
        System.out.println("The draft mail is not present in Drafts anymore");}


    @And("^appears in Sent$")
    public void appearsInSent(){
        boolean mailSent = drafts.goToSent().isMaleSent();
        Assert.assertTrue(mailSent, "The mail is not present in Sent");
        System.out.println("The mail is present in Sent");
    }
}
