package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties",
        "classpath:android.properties"
})

public interface MobileConfig extends Config {

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOsVersion();

    @Key("app")
    String getApp();

    @Key("userName")
    String getUserName();

    @Key("key")
    String getKey();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("projectName")
    String getProjectName();

    @Key("buildName")
    String getBuildName();
}