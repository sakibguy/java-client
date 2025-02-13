package io.appium.java_client.ios;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import io.appium.java_client.MobileBy;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IOSWebViewTest extends BaseIOSWebViewTest {

    @Test public void webViewPageTestCase() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("login")))
                .click();
        driver.findElement(MobileBy.AccessibilityId("webView")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Webview")));
        findAndSwitchToWebView();
        WebElement el = driver.findElement(By.partialLinkText("login"));
        assertTrue(el.isDisplayed());
    }
}
