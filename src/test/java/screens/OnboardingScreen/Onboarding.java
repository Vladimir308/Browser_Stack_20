package screens.OnboardingScreen;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class Onboarding {
    private final SelenideElement textElement = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement getStartButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));
    private final SelenideElement searchContainer = $(id("org.wikipedia.alpha:id/search_container"));

    public void verifyText(String expectedText) {
        textElement.shouldHave(text(expectedText));
    }

    public void clickContinue() {
        continueButton.shouldBe(visible).click();
    }

    public void clickGetStart() {
        getStartButton.shouldBe(visible).click();
    }

    public void shouldBeVisible() {
        searchContainer.shouldBe(visible);
    }
}