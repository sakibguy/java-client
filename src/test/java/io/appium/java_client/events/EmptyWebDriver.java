package io.appium.java_client.events;

import com.google.common.collect.ImmutableList;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyWebDriver implements WebDriver, ContextAware, Rotatable, JavascriptExecutor, HasCapabilities,
        TakesScreenshot {

    private static List<StubWebElement> createStubList() {
        return ImmutableList.of(new StubWebElement(), new StubWebElement());
    }

    @Override public WebDriver context(String name) {
        return null;
    }

    @Override public Set<String> getContextHandles() {
        return null;
    }

    @Override public String getContext() {
        return StringUtils.EMPTY;
    }

    @Override public void rotate(ScreenOrientation orientation) {
        //The rotation does nothing there
    }

    @Override public void rotate(DeviceRotation rotation) {
        //The rotation does nothing there
    }

    @Override public ScreenOrientation getOrientation() {
        return null;
    }

    @Override public DeviceRotation rotation() {
        return null;
    }

    @Override public void get(String url) {
        //There is no navigation. It is added only for event firing
    }

    @Override public String getCurrentUrl() {
        return null;
    }

    @Override public String getTitle() {
        return null;
    }

    @Override public StubWebElement findElement(By by) {
        return new StubWebElement();
    }

    @Override public List<StubWebElement> findElements(By by) {
        return createStubList();
    }

    @Override public String getPageSource() {
        throw new WebDriverException();
    }

    @Override public void close() {
        //There is no closing
    }

    @Override public void quit() {
        //It is only the stub
    }

    @Override public Set<String> getWindowHandles() {
        return null;
    }

    @Override public String getWindowHandle() {
        throw new WebDriverException();
    }

    @Override public TargetLocator switchTo() {
        return new StubTargetLocator(this);
    }

    @Override public Navigation navigate() {
        return new StubNavigation();
    }

    @Override public Options manage() {
        return new StubOptions();
    }

    @Override public Object executeScript(String script, Object... args) {
        return null;
    }

    @Override public Object executeAsyncScript(String script, Object... args) {
        return null;
    }

    @Override public Capabilities getCapabilities() {
        Map<String, Object> map = new HashMap<>();
        map.put("0",StringUtils.EMPTY);
        map.put("1",StringUtils.EMPTY);
        return new DesiredCapabilities(map);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return target.convertFromPngBytes(new byte[]{1,2});
    }

    private class StubTargetLocator implements TargetLocator {

        private final WebDriver driver;

        StubTargetLocator(WebDriver driver) {
            this.driver = driver;
        }

        @Override public WebDriver frame(int index) {
            return driver;
        }

        @Override public WebDriver frame(String nameOrId) {
            return driver;
        }

        @Override public WebDriver frame(WebElement frameElement) {
            return driver;
        }

        @Override public WebDriver parentFrame() {
            return driver;
        }

        @Override public WebDriver window(String nameOrHandle) {
            return driver;
        }

        @Override
        public WebDriver newWindow(WindowType typeHint) {
            return driver;
        }

        @Override public WebDriver defaultContent() {
            return driver;
        }

        @Override public WebElement activeElement() {
            return new StubWebElement();
        }

        @Override public Alert alert() {
            return new StubAlert();
        }
    }

    private class StubOptions implements Options {

        @Override public void addCookie(Cookie cookie) {
            //STUB: No adding cookie
        }

        @Override public void deleteCookieNamed(String name) {
            //STUB No removal cookie
        }

        @Override public void deleteCookie(Cookie cookie) {
            //STUB No deleting cookie
        }

        @Override public void deleteAllCookies() {
            //STUB it does nothing
        }

        @Override public Set<Cookie> getCookies() {
            return null;
        }

        @Override public Cookie getCookieNamed(String name) {
            return null;
        }

        @Override public Timeouts timeouts() {
            return null;
        }

        @Override public ImeHandler ime() {
            return null;
        }

        @Override public Window window() {
            return new StubWindow();
        }

        @Override public Logs logs() {
            return null;
        }
    }

    private class StubNavigation implements Navigation {

        @Override public void back() {
            //STUB: It doesn't navigate back
        }

        @Override public void forward() {
            //STUB: No the navigation forward
        }

        @Override public void to(String url) {
            //STUB: Added only for event firing
        }

        @Override public void to(URL url) {
            //STUB: Event firing of the navigation to some URL
        }

        @Override public void refresh() {
            //STUB: The firing of the refreshing
        }
    }
}
