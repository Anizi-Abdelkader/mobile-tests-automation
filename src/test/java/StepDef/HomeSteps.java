package StepDef;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomeSteps {

    private HomePage homePage = new HomePage();
    @When("I'm on search page")
    public void iSearchFor() throws InterruptedException {
        homePage.clickOnSearch();
    }
}
