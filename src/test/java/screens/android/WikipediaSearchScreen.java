package screens.android;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaSearchScreen {

    private final SelenideElement
            searchCard = $(accessibilityId("Search Wikipedia")),
            searchBar = $(id("org.wikipedia.alpha:id/search_src_text")),
            menuButton = $(id("org.wikipedia.alpha:id/menu_overflow_button")),
            nameAccount = $(id("org.wikipedia.alpha:id/explore_overflow_account_name"));

    @Step("Выполнить поиск")
    public void searchFor(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
    }

    @Step("Выполнить поиск")
    public void searchForUnsuccessful(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
        $$(id("org.wikipedia.alpha:id/page_list_item_container")).first().click();
    }

    @Step("Выполнить поиск")
    public void loginButton() {
        menuButton.click();
        nameAccount.shouldHave(text("Log in to Wikipedia"));
        nameAccount.click();
    }
}