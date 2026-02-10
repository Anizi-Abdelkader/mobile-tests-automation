package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import io.appium.java_client.AppiumBy;


import java.time.Duration;
import java.util.function.Supplier;

public abstract class BasePage {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(
                new AppiumFieldDecorator(driver, Duration.ofSeconds(10)),
                this
        );
    }

    // clicker sur un seul WebElement à chaque tour
    protected void clickUntilGone(Supplier<WebElement> elementSupplier) {
        FluentWait<AndroidDriver> waitFluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(StaleElementReferenceException.class, NullPointerException.class)
                .ignoring(org.openqa.selenium.NoSuchElementException.class); // ajouter si l'élément n'est pas encore dans le DOM

        while (true) {
            try {
                // relocaliser le WebElement à chaque tour
                WebElement element = elementSupplier.get();

                boolean visible = waitFluent.until(d -> {
                    try {
                        return element.isDisplayed();
                    } catch (StaleElementReferenceException | NullPointerException e) {
                        return false;
                    }
                });

                if (!visible) break;
                // clicker sur le webElement
                element.click();
                waitFluent.until(ExpectedConditions.invisibilityOf(element));

            } catch (Exception e) {
                break;
            }
        }
    }

    // clicker sur le webElement lorsque il est visible
    protected void clickWhenVisible(Supplier<WebElement> elementSupplier) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement element = localWait.until(d -> {
                try {
                    WebElement el = elementSupplier.get();
                    return el.isDisplayed() ? el : null;
                } catch (StaleElementReferenceException | NullPointerException ex) {
                    return null;
                }
            });
            element.click();
            localWait.until(ExpectedConditions.invisibilityOf(element));

        } catch (Exception e) {
            throw new RuntimeException("Element non trouvé" + e.getMessage());
        }
    }

    protected boolean scrollToText(String text) {
        try {
            driver.findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
                    )
            );
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
