package StepDef;

import io.cucumber.java.en.And;
import pages.LanguagePage;
import pages.SearchPage;


public class LanguageSteps {
    private LanguagePage languagePage = new LanguagePage();
    private SearchPage searchPage = new SearchPage();

    @And("I change the website language to French")
    public void iChangeTheWebsiteLanguageToFrench() {
        languagePage.clickOnAddLanguageBtn();
        languagePage.clickOnFrenchBtn();
        languagePage.clickOnGoBackBtn();
        searchPage.closeSystemPopup();
        searchPage.clickOnFrenchLang();
    }
}
