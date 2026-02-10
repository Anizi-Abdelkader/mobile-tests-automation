package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LanguagePage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"org.wikipedia.alpha:id/wiki_language_title\" and @text=\"Add language\"]")
    private WebElement addLanguageBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Français\"]")
    private WebElement frenchBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement goBackBtn;

    public void clickOnAddLanguageBtn() {
        addLanguageBtn.click();
    }

    public void clickOnFrenchBtn() {
        frenchBtn.click();
    }

    public void clickOnGoBackBtn() {
        goBackBtn.click();
    }
}
