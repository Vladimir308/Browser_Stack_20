package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})
public interface BrowserStackConfig extends Config {

    @Key("remoteWebDriverUrl")
    String getRemoteWebDriverUrl();
}