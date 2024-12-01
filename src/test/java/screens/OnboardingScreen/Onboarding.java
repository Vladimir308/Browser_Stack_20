package screens.OnboardingScreen;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class Onboarding {

    private final SelenideElement
            textElement = $(id("org.wikipedia.alpha:id/primaryTextView")),
            continueButton = $(id("org.wikipedia.alpha:id/continueButton")),
            getStartButton = $(id("org.wikipedia.alpha:id/getStartButton")),
            searchContainer = $(id("org.wikipedia.alpha:id/search_container"));

    public void verifyText(String expectedText) {
        assertThat(textElement.getText()).isEqualTo(expectedText);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickGetStart() {
        getStartButton.click();
    }

    public void shouldBeVisible() {
        searchContainer.shouldBe(visible);
    }
}
