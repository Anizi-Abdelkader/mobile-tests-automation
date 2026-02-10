package StepDef;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

import static org.junit.Assert.assertTrue;

public class SearchSteps {

private SearchPage searchPage = new SearchPage();

    @When("I search for {string}")
    public void iSearchFor(String txt) throws InterruptedException {
    searchPage.SearchTxt(txt);
    }

    @Then("Lydia city is visible and i dismiss the popup")
    public void lydiaCityIsVisibleAndIDismissThePopup() {
        if (!searchPage.isLydiaCityPresent())
            searchPage.closeSystemPopup();
        assertTrue("Lydia city n'est pas visible", searchPage.isLydiaCityPresent());

    }

    @And("I go to language page")
    public void iGoToLanguagePage() {
        searchPage.clickOnLanguageBtn();
    }
}
