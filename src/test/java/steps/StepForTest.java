package steps;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertEquals;
import static utils.BaseConstant.TASK4;
import static utils.CitizenCreator.createCitizen;

public class StepForTest extends BaseTest {

    @Given("Open citizen CNP page")
    public void openCitizenCNPPage() {
        pageContainer.citizenCNPPage().openPage(TASK4);
        String pageTitle = pageContainer.citizenCNPPage().getPageTitle();
        assertEquals(pageTitle, "Testing Challenge #4 - generate testing data",
                String.format("The page title '%s' does not match the expected title", pageTitle));
    }

    @When("Click on CNP input field")
    public void clickOnCNPInputField() {
        pageContainer.citizenCNPPage().clickFieldCNPNumber();
    }

    @And("Enter random correct generated CNP")
    public void enterRandomCorrectGeneratedCNP() {
        pageContainer.citizenCNPPage().inputValueInField(createCitizen().createCNP());
    }

    @And("Click check validate CNP")
    public void clickCheckValidity() {
        pageContainer.citizenCNPPage().clickCheckValidity();
    }

    @Then("Result message says {string} CNP number was added")
    public void resultMessageSaysCNPNumberWasAdded(String value) {
        String message = pageContainer.citizenCNPPage().getInformationAboutAddedValidCNPNumbers();
        assertEquals(message, String.format("Valid CNP numbers added %s out of 5", value),
                String.format("The message '%s' does not match the expected message", message));
    }

    @Then("Result message about final successful result")
    public void resultMessageAboutSuccessfulResult() {
        String message = pageContainer.citizenCNPPage().getInformationAboutSuccessfulResult();
        assertEquals(message, "YOU HAVE DONE IT. Please enter your name.",
                String.format("The message '%s' does not match the expected message", message));
    }
}
