package tests.android;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.android.WikipediaSearchResultsScreen;
import screens.android.WikipediaSearchScreen;
import tests.TestBase;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("android")
public class WikipediaTests extends TestBase {
    WikipediaSearchScreen wikipediaSearchScreen = new WikipediaSearchScreen();
    WikipediaSearchResultsScreen wikipediaSearchResultsScreen = new WikipediaSearchResultsScreen();


    @Test
    @DisplayName("Проверить успешные результаты поиска в приложении Wikipedia")
    public void successfulSearchTest() {
        String query = "Appium";
        wikipediaSearchScreen.searchFor(query);
        assertThat(wikipediaSearchResultsScreen.getResultsCount()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Проверить сообщение об ошибке при неудачном поиске в приложении Wikipedia")
    public void unsuccessfulSearchTest() {
        String query = "Java";
        wikipediaSearchScreen.searchForUnsuccessful(query);
        wikipediaSearchResultsScreen.ResultError();
    }

    @Test
    @DisplayName("Проверка наличия регистрации в приложении Wikipedia")
    public void checkLogInButtonTest() {
        wikipediaSearchScreen.loginButton();
        wikipediaSearchResultsScreen.ResultLogin();
    }
}