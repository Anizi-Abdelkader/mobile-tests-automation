package pages;

import StepDef.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

import java.time.Duration;

public class welcomePage {
    private AndroidDriver driver;


    @AndroidFindBy(id = "org.wikipedia.alpha:id/fragment_onboarding_forward_button")
    private WebElement cntBtn;

    public welcomePage() {
        // Récupérer le driver automatiquement depuis DriverManager
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void clickOnCtnBtn() {
        cntBtn.click();
    }
}
