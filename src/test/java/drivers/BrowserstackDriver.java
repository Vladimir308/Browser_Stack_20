package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackAuthConfig;
import config.LocalConfig;
import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {


    @Getter
    public static BrowserstackAuthConfig authConfig = ConfigFactory.create(BrowserstackAuthConfig.class, System.getProperties());
    public static LocalConfig deviceConfig = ConfigFactory.create(LocalConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", authConfig.getUserName());
        caps.setCapability("browserstack.key", authConfig.getKey());


        caps.setCapability("device", deviceConfig.getDeviceName());
        caps.setCapability("os_version", deviceConfig.getPlatformVersion());
        caps.setCapability("app", deviceConfig.getAppUrl());

        caps.setCapability("project", "Wikipedia Mobile Tests Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "wikipedia_tests");

        caps.setCapability("fullReset", true);

        try {
            return new RemoteWebDriver(
                    new URL(authConfig.getRemoteWebDriverUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}