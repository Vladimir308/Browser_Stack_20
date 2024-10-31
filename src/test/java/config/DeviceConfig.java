package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:android.properties",
        "classpath:${device}.properties"
})
public interface DeviceConfig extends Config {

    @Key("device.name")
    String geyDeviceName();

    @Key("platform.version")
    String getPlatformVersion();

    @Key("appUrl")
    String getAppUrl();

    @Key("platformName")
    String getPlatformName();

    @Key("projectName")
    String getProject();

    @Key("buildName")
    String getBuild();
}