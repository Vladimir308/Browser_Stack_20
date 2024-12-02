package screens.android;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchResultsScreen {

    private final ElementsCollection foundItems = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));
    private final SelenideElement loginText = $(id("org.wikipedia.alpha:id/login_button"));
    private final SelenideElement searchContainer = $(id("org.wikipedia.alpha:id/search_container"));

    @Step("Успешный результат больше 0")
    public int getResultsCount() {
        return foundItems.size();
    }

    @Step("Результат error text")
    public void ResultError() {
        errorText.shouldBe(visible);
    }

    @Step("Успешный результат, видимость кнопки Login")
    public void ResultLogin() {
        loginText.shouldHave(text("Log in"));
    }

    @Step("Проверяем, что открылась страница с поиском")
    public void shouldBeVisible() {
        searchContainer.shouldBe(visible);
    }
}