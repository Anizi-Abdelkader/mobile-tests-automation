package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{

    @AndroidFindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private WebElement searchTxtField;

    @AndroidFindBy(id = "")
    private WebElement closePopupBtn;

    public void SearchTxt(String txt) {
        searchTxtField.sendKeys(txt);
    }

    public boolean isLydiaCityPresent() {
        return scrollToText("Ancient Anatolian kingdom");
    }

    public void closePopup() {
        closePopupBtn.click();
    }

}
