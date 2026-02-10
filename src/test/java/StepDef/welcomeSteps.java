package StepDef;

import io.cucumber.java.en.Given;
import pages.welcomePage;

public class welcomeSteps {
    private welcomePage WelcomePage = new welcomePage();

    @Given("the user is on welcome page")
    public void theUserIsOnWelcomePage() {
        WelcomePage.clickOnCtnBtn();
    }
}
