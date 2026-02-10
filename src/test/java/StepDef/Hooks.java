package StepDef;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.appium.java_client.android.AndroidDriver;
import utils.AppiumConfig;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        try {
            AppiumConfig config = new AppiumConfig("src/test/resources/capabilities.json");
            AndroidDriver driver = new AndroidDriver(config.getUrl(), config.getOptions());
            DriverManager.setDriver(driver);
            System.out.println("Session Appium démarrée avec succès.");
        } catch (Exception e) {
            throw new RuntimeException("Impossible de démarrer la session Appium : " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
        System.out.println("Session Appium terminée.");
    }
}
