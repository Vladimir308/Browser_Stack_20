package tests.local;

import org.junit.jupiter.api.*;
import screens.android.WikipediaOnboardingScreen;
import screens.android.WikipediaSearchResultsScreen;
import tests.TestBase;

@Tag("emulation")
public class WikipediaOnboardingScreenTest extends TestBase {
    WikipediaOnboardingScreen onboarding = new WikipediaOnboardingScreen();
    WikipediaSearchResultsScreen onboardingResult = new WikipediaSearchResultsScreen();

    @Test
    @DisplayName("Проверка стартовых страниц Wikipedia")
    public void onboardingScreenTest() {
        String firstText = "The Free Encyclopedia\n…in over 300 languages";
        String secondText = "New ways to explore";
        String thirdText = "Reading lists with sync";
        String fourthText = "Data & Privacy";
        onboarding.verifyText(firstText);
        onboarding.clickContinue();
        onboarding.verifyText(secondText);
        onboarding.clickContinue();
        onboarding.verifyText(thirdText);
        onboarding.clickContinueButton();
        onboarding.verifyText(fourthText);
        onboarding.clickGetStart();
        onboardingResult.shouldBeVisible();
    }
}