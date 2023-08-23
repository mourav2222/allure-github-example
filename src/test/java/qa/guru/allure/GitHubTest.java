package qa.guru.allure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@ExtendWith(MyReportPortalExtension.class)
public class GitHubTest extends BaseTest {

//    @BeforeAll
//    static void setup() {
//
//        String idea = System.getProperty("idea");
//        System.out.println("idea: " + idea);
//
//        if(!Boolean.valueOf(idea)) {
//            Configuration.remote = "http://localhost:4444/wd/hub";
//        }
//        SelenideLogger.addListener("allure", new AllureSelenide());
//
//    }

    @Test
    @DisplayName("Search for issue with number 74")
    void searchForIssue74() {

        step("Open github XXX...");
        open("https://github.com");
        $(".header-search-button ").click();
//        $(byId("query-builder-test")).sendKeys("allure-example");

        $("#query-builder-test").sendKeys("allure-example");
        $("#query-builder-test").submit();

        $(byLinkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#74")).should(exist);
    }

    @Test
    @DisplayName("BaseTest: Search for issue with number 80")
    void searchForIssueBaseTest1() {

        openMainPage();

        searchForRepository("allure-example");

        step("Open repository by link", () -> $(byLinkText("eroshenkoam/allure-example")).click());

        step("Open issue tab", ()-> $("#issues-tab").click());

        step("Should see issue with number 80", () -> $(withText("#80")).should(exist));
    }


    @Test
    @DisplayName("Search for issue with number 80")
    void searchForIssue1() {

        step("Open main page", () -> open("https://github.com"));

        step("Search for repository", () -> {
            $(".header-search-button ").click();
            $("#query-builder-test").sendKeys("allure-example");
            $("#query-builder-test").submit();
        });
        step("Open repository by link", () -> $(byLinkText("eroshenkoam/allure-example")).click());

        step("Open issue tab", ()-> $("#issues-tab").click());

        step("Should see issue with number 80", () -> $(withText("#80")).should(exist));
    }

    @Test
    @DisplayName("Search for issue with number 81")
    void searchForIssue2() {

        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForReository("allure-example");
        steps.openRepositoryByLink("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(80);

    }
}
