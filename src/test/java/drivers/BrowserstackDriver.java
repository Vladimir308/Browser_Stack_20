package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.BrowserStackConfig;
import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.System.*;

public class BrowserstackDriver implements WebDriverProvider {
    public static DeviceConfig deviceconfig = ConfigFactory.create(DeviceConfig.class, getProperties());
    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, getProperties());
    public static BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class, getProperties());

    @Nonnull
    @Override

    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", authConfig.getUserName());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getPassword());

        mutableCapabilities.setCapability("app", deviceconfig.getAppUrl());
        mutableCapabilities.setCapability("deviceName", deviceconfig.geyDeviceName());
        mutableCapabilities.setCapability("osVersion", deviceconfig.getPlatformVersion());

        mutableCapabilities.setCapability("platformName", deviceconfig.getPlatformName());
        mutableCapabilities.setCapability("projectName", deviceconfig.getProject());
        mutableCapabilities.setCapability("buildName", deviceconfig.getBuild());

        try {
            return new RemoteWebDriver(
                    new URL(browserStackConfig.getRemoteWebDriverUrl()), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}