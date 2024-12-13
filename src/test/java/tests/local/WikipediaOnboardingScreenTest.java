package tests.local;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import screens.android.WikipediaOnboardingScreen;
import screens.android.WikipediaSearchResultsScreen;
import screens.android.*;
import tests.TestBase;

@Tag("emulation")
public class WikipediaOnboardingScreenTest extends TestBase {
    WikipediaOnboardingScreen onboarding = new WikipediaOnboardingScreen();
    WikipediaSearchResultsScreen onboardingResult = new WikipediaSearchResultsScreen();
    WelcomePage welcomePage = new WelcomePage();
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ArticlePage articlePage = new ArticlePage();

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
        onboarding.clickContinue();
        onboarding.verifyText(fourthText);
        onboarding.clickGetStart();
        onboardingResult.shouldBeVisible();
    }

    @ParameterizedTest(name = "Search term: {0}")
    @ValueSource(strings = {"White Rabbit", "Venus"})
    void searchTest(String searchTerm) {
        welcomePage.skipButtonClick();
        mainPage.searchClick();
        searchPage.searchQuery(searchTerm);
        searchPage.checkTheQuantity();
        searchPage.clickFirstElementResultList();
        articlePage.findText(searchTerm);
    }
}