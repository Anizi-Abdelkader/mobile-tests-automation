package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Search Wikipedia\"]")
    private WebElement SearchTxtField;

    public void clickOnSearch() throws InterruptedException {
        SearchTxtField.click();
        Thread.sleep(30000);
        driver.navigate().back();
    }

}
