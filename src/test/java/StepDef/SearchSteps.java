package StepDef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

private SearchPage searchPage = new SearchPage();

    @When("I search for {string}")
    public void iSearchFor(String txt) {
    searchPage.SearchTxt(txt);
    }

    @Then("Lydia city is visible and i dismiss the popup")
    public void lydiaCityIsVisibleAndIDismissThePopup() {
        assertTrue("Lydia city n'est pas visible", searchPage.isLydiaCityPresent());
        searchPage.closePopup();
    }
}
