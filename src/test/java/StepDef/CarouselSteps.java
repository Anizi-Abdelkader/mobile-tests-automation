package StepDef;

import io.cucumber.java.en.Given;
import pages.CarouselPage;

public class CarouselSteps {
    private CarouselPage carouselPage = new CarouselPage();

    @Given("I'm on the carousel and I'm scrolling through it")
    public void theUserSwipeCarousel() throws InterruptedException {
        carouselPage.clickContinueWhileVisible();
        carouselPage.clickGetStartedBtn();
    }
}
