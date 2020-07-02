package com.core.base;

import com.core.allure.AllureLogger;
import com.core.config.SelenideConfig;
import com.codeborne.selenide.Selenide;
import com.core.utils.Constants;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest extends AllureLogger {

    @BeforeClass(alwaysRun = true, description = "Opening web browser...")
    public void setUp() {
        logInfo("Creating web driver configuration...");
        SelenideConfig.createBrowserConfig(System.getProperty("browser", "chrome"));

        logInfo("Open browser...");
        Selenide.open(Constants.MAIN_PAGE_URL);
    }

    @AfterClass(alwaysRun = true, description = "Closing web browser...")
    public void tearDown() {
        Selenide.closeWebDriver();
        logInfo("Web driver closed!");
    }
}
