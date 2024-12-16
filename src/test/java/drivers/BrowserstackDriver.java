package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    public static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", mobileConfig.getUserName());
        caps.setCapability("browserstack.key", mobileConfig.getKey());

        caps.setCapability("app", mobileConfig.getApp());
        caps.setCapability("device", mobileConfig.getDevice());
        caps.setCapability("os_version", mobileConfig.getOsVersion());

        caps.setCapability("project", mobileConfig.getProjectName());
        caps.setCapability("build", mobileConfig.getBuildName());
        caps.setCapability("name", "test " + mobileConfig.getDevice());

        try {
            return new RemoteWebDriver(
                    new URL(mobileConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}