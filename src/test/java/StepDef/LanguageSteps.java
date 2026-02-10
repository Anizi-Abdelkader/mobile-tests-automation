package StepDef;

import io.cucumber.java.en.And;
import pages.LanguagePage;

public class LanguageSteps {
    private LanguagePage languagePage = new LanguagePage();

    @And("I change the website language to French")
    public void iChangeTheWebsiteLanguageToFrench() {
        languagePage.clickOnAddLanguageBtn();
        languagePage.clickOnFrenchBtn();
        languagePage.clickOnGoBackBtn();
    }
}
