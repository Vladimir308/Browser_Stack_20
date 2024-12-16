package screens.android;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    private final SelenideElement searchInput = $(id("org.wikipedia.alpha:id/search_src_text"));

    private final ElementsCollection listTitles = $$(id("org.wikipedia.alpha:id/page_list_item_title")),
            searchResultListDescriptions = $$(id("org.wikipedia.alpha:id/page_list_item_description"));


    @Step("Вводим название статьи для поиска")
    public SearchPage searchQuery(String value) {
        searchInput.sendKeys(value);
        return this;
    }

    @Step("Проверяем вывод статей в списке поиска")
    public SearchPage checkTheQuantity() {
        listTitles.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Кликаем на первый элемент выпадающего списка поиска")
    public SearchPage clickFirstElementResultList() {
        searchResultListDescriptions.first().click();
        return this;
    }
}