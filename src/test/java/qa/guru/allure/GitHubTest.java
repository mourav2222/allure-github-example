package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubTest {

    @Test
    void searchForIssue() {

        String idea = System.getenv("idea");
        System.out.println("idea: " + idea);

        Configuration.remote = "http://localhost:4444/wd/hub";
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $(".header-search-button ").click();
//        $(byId("query-builder-test")).sendKeys("allure-example");

        $("#query-builder-test").sendKeys("allure-example");
        $("#query-builder-test").submit();

        $(byLinkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#81")).should(exist);
    }
}
