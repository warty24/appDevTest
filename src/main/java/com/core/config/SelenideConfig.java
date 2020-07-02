package com.core.config;

import com.codeborne.selenide.Configuration;
import com.core.utils.DateTime;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SelenideConfig {
    private static final String VIDEO_NAME_PATTERN = "HH:mm:ss:SSS";

    /*For Selenoid*/
    private static DesiredCapabilities getBrowserCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", Boolean.parseBoolean(System.getProperty("enableVnc", "true")));
        capabilities.setCapability("enableVideo", Boolean.parseBoolean(System.getProperty("enableVideo", "false")));
        capabilities.setCapability("videoName", String.format("video_%s.mp4", DateTime.getLocalDateTimeByPattern(VIDEO_NAME_PATTERN)));
        capabilities.setCapability("sessionTimeout", "5m");
        return capabilities;
    }

    public static void createBrowserConfig(String browser) {
        Configuration.browser = browser;

        /*Configuration.driverManagerEnabled = false;
        Configuration.remote = PropertyLoader.get("remote_url");
        Configuration.browserCapabilities = getBrowserCapabilities();*/

        Configuration.holdBrowserOpen = false;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        Configuration.startMaximized = true;
        Configuration.browserSize="1920x1080";

        Configuration.fastSetValue = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = true;
        Configuration.pollingInterval = 5000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 12000;
    }
}
