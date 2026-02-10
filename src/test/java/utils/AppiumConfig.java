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

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> configMap = mapper.readValue(new File(jsonPath), Map.class);

        UiAutomator2Options androidOptions = new UiAutomator2Options();

        Map<String, Object> capsMap = (Map<String, Object>) configMap.get("capabilities");

        if (capsMap == null) {
            throw new RuntimeException("Le JSON ne contient pas de champ 'capabilities'");
        }


        if (capsMap.containsKey("platformName")) {
            androidOptions.setPlatformName((String) capsMap.get("platformName"));
        }
        if (capsMap.containsKey("appium:automationName")) {
            androidOptions.setAutomationName((String) capsMap.get("appium:automationName"));
        }
        if (capsMap.containsKey("appium:deviceName")) {
            androidOptions.setDeviceName((String) capsMap.get("appium:deviceName"));
        }
        if (capsMap.containsKey("appPackage")) {
            androidOptions.setAppPackage((String) capsMap.get("appPackage"));
        }
        if (capsMap.containsKey("appActivity")) {
            androidOptions.setAppActivity((String) capsMap.get("appActivity"));
        }

        for (Map.Entry<String, Object> entry : capsMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (key.equals("platformName") || key.equals("appium:automationName") ||
                    key.equals("appium:deviceName") || key.equals("appPackage") || key.equals("appActivity")) {
                continue;
            }

            androidOptions.setCapability(key, value);
        }

        this.options = androidOptions;

        String urlString = configMap.getOrDefault("serverUrl", "http://127.0.0.1:4723").toString();

        try {
            this.url = new URL(urlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL du serveur Appium invalide : " + urlString, e);
        }
    }

    public BaseOptions<?> getOptions() {
        return options;
    }

    public URL getUrl() {
        return url;
    }
}
