package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface DeviceConfig extends Config {

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("app")
    String getApp();
}