package qa.guru.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class WebSteps {

    @Step("Open main page")
    void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for repository {repo}")
    void searchForReository(String repo) {
        $(".header-search-button ").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Open repository by link {link}")
    void openRepositoryByLink(String link) {
        $(byLinkText(link)).click();
    }

    @Step("Open issue tab")
    public void openIssueTab() {

        $("#issues-tab").click();
    }

    @Step("Should see issue with number {num}")
    public void shouldSeeIssueWithNumber(int num) {
        $(withText("#" + num)).should(exist);

    }
}

