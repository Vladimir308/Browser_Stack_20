package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})

public interface BrowserstackAuthConfig extends Config {

    @Key("userName")
    String getUserName();

    @Key("key")
    String getKey();

    @Key("remoteUrl")
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String getRemoteUrl();
}