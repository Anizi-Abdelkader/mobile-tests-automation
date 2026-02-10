package pages;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private WebElement searchTxtField;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_close_btn")
    private WebElement closePopupBtn;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/langCodeText")
    private WebElement languageBtn;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/langCodeText")
    private WebElement frenchLangBtn;

    public void SearchTxt(String txt) throws InterruptedException {
        searchTxtField.sendKeys(txt);
    }

    public boolean isLydiaCityPresent() {
        return scrollToText("Ancient Anatolian kingdom");
    }
    public void closeSystemPopup() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


    public void clickOnLanguageBtn() {
        languageBtn.click();
}
    public void clickOnFrenchLang() {
        frenchLangBtn.click();
    }
}