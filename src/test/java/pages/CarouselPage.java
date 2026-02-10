package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class CarouselPage extends BasePage{

    @AndroidFindBy(id = "org.wikipedia.alpha:id/fragment_onboarding_forward_button")
    private WebElement cntBtn;

    @AndroidFindBy(id = "org.wikipedia.alpha:id/fragment_onboarding_done_button")
    private WebElement getStartedBtn;


    public void clickContinueWhileVisible() throws InterruptedException {
            java.util.stream.IntStream.range(0, 3).forEach(i -> cntBtn.click());
    }

    public void clickGetStartedBtn() {
         getStartedBtn.click();
    }
}
