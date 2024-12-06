package tests.ios;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Tag("ios")
public class IosTests extends TestBase {

    @Test
    @DisplayName("Успешный поиск Appium")
    public void searchTest() {
        String searchQuery = "Appium";
        step("Нажать на Text button", () -> {
            $(accessibilityId("Text Button")).click();
        });
        step("ввести текст", () -> {
            $(accessibilityId("Text Input")).sendKeys(searchQuery + "\n");
        });
        step("Проверить что отобразился  правильный текст", () -> {
            $(accessibilityId("Text Output")).shouldHave(text(searchQuery));
        });
    }

    @Test
    @DisplayName("Видимость заголовка")
    public void visibleMainPageTest() {
        step("Проверка главной страницы", () -> {
            $(name("Alert")).shouldBe(visible);
            $(name("Text")).shouldBe(visible);
        });
    }
}