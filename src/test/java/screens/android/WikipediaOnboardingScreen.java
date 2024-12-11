package screens.android;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaOnboardingScreen {
    private final SelenideElement textElement = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement getStartButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Проверить что текст {expectedText} отображается на странице")
    public void verifyText(String expectedText) {
        textElement.shouldHave(text(expectedText));
    }

    @Step("Нажать на кнопку Continue")
    public void clickContinue() {
        continueButton.shouldBe(visible).click();
    }

    @Step("Нажать на кнопку Get Started")
    public void clickGetStart() {
        getStartButton.shouldBe(visible).click();
    }
}