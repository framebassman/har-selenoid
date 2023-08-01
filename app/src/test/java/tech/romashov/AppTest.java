/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tech.romashov;

import com.blibli.oss.qa.util.services.NetworkListener;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }

    @Test
    public void harFile() throws Exception {
        Configuration.browser = "tech.romashov.SelenoidWebDriverProvider";
        WebDriver driver = WebDriverRunner.getAndCheckWebDriver();
        NetworkListener networkListener = new NetworkListener(WebDriverRunner.getWebDriver(), String.format("logs-%s.har", System.currentTimeMillis()), "0.0.0.0:4444");
        networkListener.start();
        Selenide.open("https://ya.ru");
        Selenide.closeWebDriver();
        networkListener.createHarFile();
    }
}