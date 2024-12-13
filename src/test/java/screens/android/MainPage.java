package screens.android;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainPage {

    private final SelenideElement searchWikipedia = $(accessibilityId("Search Wikipedia"));

    @Step("Кликаем на строку поиска Википедии")
    public MainPage searchClick() {
        searchWikipedia.click();
        return this;
    }
}
