package tests.local;

import org.junit.jupiter.api.*;
import screens.OnboardingScreen.Onboarding;
import tests.TestBase;

import static io.qameta.allure.Allure.step;

@Tag("emulation")
public class OnboardingScreenTest extends TestBase {
    Onboarding onboarding = new Onboarding();

    @Test
    @DisplayName("Проверка стартовых страниц Wikipedia")
    public void onboardingScreenTest() {
        String firstText = "The Free Encyclopedia\n…in over 300 languages";
        String secondText = "New ways to explore";
        String thirdText = "Reading lists with sync";
        String fourthText = "Data & Privacy";

        step("Проверяем заголовок первой страницы и переходим на следующую страницу", () -> {
            onboarding.verifyText(firstText);
            onboarding.clickContinue();
        });
        step("Проверяем заголовок второй страницы и переходим на следующую страницу", () -> {
            onboarding.verifyText(secondText);
            onboarding.clickContinue();
        });
        step("Проверяем заголовок третьей страницы и переходим на следующую страницу", () -> {
            onboarding.verifyText(thirdText);
            onboarding.clickContinue();
        });
        step("Проверяем заголовок четвертой страницы и переходим на следующую страницу", () -> {
            onboarding.verifyText(fourthText);
            onboarding.clickGetStart();
        });
        step("Проверяем, что открылась страница с поиском", () -> {
            onboarding.shouldBeVisible();
        });
    }
}
//
//
//    WikipediaSearchScreen wikipediaSearchScreen = new WikipediaSearchScreen();
//    @Test
//    @DisplayName("Проверка стартовых страниц Wikipedia")
//    public void onboardingScreenTest() {
//        String firstText = "The Free Encyclopedia\n…in over 300 languages",
//                secondText = "New ways to explore",
//                thirdText = "Reading lists with sync",
//                fourthText = "Data & Privacy";
//
//        step("Проверяем заголовок первой страницы и переходим на следующую страницу", () -> {
//            assertThat(textElement.getText())
//                    .isEqualTo(firstText);
//            wikipediaSearchScreen.clickContinueButton();
//        });
//
//        step("Проверяем заголовок второй страницы и переходим на следующую страницу", () -> {
//            assertThat(textElement.getText())
//                    .isEqualTo(secondText);
//            wikipediaSearchScreen.clickContinueButton();
//        });
//
//        step("Проверяем заголовок третьей страницы и переходим на следующую страницу", () -> {
//            assertThat(textElement.getText())
//                    .isEqualTo(thirdText);
//            wikipediaSearchScreen.clickContinueButton();
//        });
//
//        step("Проверяем заголовок четвертой страницы и переходим на следующую страницу", () -> {
//            assertThat(textElement.getText())
//                    .isEqualTo(fourthText);
//            wikipediaSearchScreen.clickGetStartButton();
//        });
//
//        step("Проверяем, что открылась страница с поиском", () ->
//                assertTrue(searchContainer.isEnabled()));
//    }