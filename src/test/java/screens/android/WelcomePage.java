package screens.android;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WelcomePage {

    private final SelenideElement skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    @Step("Пропускаем страницы приветствия")
    public WelcomePage skipButtonClick() {
        skipButton.click();
        return this;
    }
}