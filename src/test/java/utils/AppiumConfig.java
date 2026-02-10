package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AppiumConfig {

    private BaseOptions<?> options;
    private URL url;

    public AppiumConfig(String jsonPath) throws Exception {
        // Charger le fichier JSON
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> configMap = mapper.readValue(new File(jsonPath), Map.class);

        // Créer les options Android (adapter si iOS)
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        androidOptions.setPlatformName((String) configMap.get("platformName"));
        androidOptions.setDeviceName((String) configMap.get("deviceName"));
        androidOptions.setAppPackage((String) configMap.get("appPackage"));
        androidOptions.setAppActivity((String) configMap.get("appActivity"));

        this.options = androidOptions;

        // URL du serveur Appium
        String urlString = configMap.getOrDefault("url", "http://127.0.0.1:4723").toString();
        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL du serveur Appium invalide : " + urlString);
        }
    }

    public BaseOptions<?> getOptions() {
        return options;
    }

    public URL getUrl() {
        return url;
    }
}
