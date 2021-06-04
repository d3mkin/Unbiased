package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    /**
     * Tests setup
     */
    @BeforeAll
    public static void setup() {
        Configuration.baseUrl = "https://www.unbiased.co.uk/";
        Configuration.startMaximized = true;
    }

    /**
     * Tests teardown
     */
    @AfterAll
    public static void closeBrowser() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
    }
}
