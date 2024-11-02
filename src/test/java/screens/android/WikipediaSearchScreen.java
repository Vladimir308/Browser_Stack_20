package screens.android;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class WikipediaSearchScreen {

    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchBar = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final SelenideElement menuButton = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement nameAccount = $(accessibilityId("org.wikipedia.alpha:id/explore_overflow_account_name"));

    @Step("Perform search")
    public void searchFor(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
    }

    @Step("Perform search")
    public void searchForUnsuccessful(String query) {
        searchCard.click();
        searchBar.sendKeys(query);
        $$(className("org.wikipedia.alpha:id/page_list_item_container")).first().click();
    }
    @Step("Perform search")
    public void loginButton() {
        menuButton.click();
        nameAccount.shouldHave(text("Log in to Wikipedia")).click();
    }
}