package qa.guru.allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class GitHubTest003 {

    private static Logger LOGGER = LoggerFactory.getLogger(GitHubTest003.class);
    private final long SLEEPTIME = 10000;

    @BeforeAll
    static void setup() {

        String idea = System.getProperty("idea");
        System.out.println("idea: " + idea);

        if(!Boolean.parseBoolean(idea)) {
            Configuration.remote = "http://localhost:4444/wd/hub";
            System.out.println("Configuration.remote: " + Configuration.remote);
        }

        String selenoid_srv = System.getenv("SELENOID_TEST");
        if(selenoid_srv != null) {
            Configuration.remote = "http://" + selenoid_srv + ":4444/wd/hub";
        }

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", true);
        options.put("enableLog", true);

        //capabilities.setBrowserVersion("100.0");
        Configuration.browserCapabilities = new ChromeOptions();
        Configuration.browserCapabilities.setCapability("selenoid:options", options);

        SelenideLogger.addListener("allure", new AllureSelenide());

    }

    @Test
    @DisplayName("Search for issue with number 74")
    void searchForIssue() {

        open("https://github.com");
        $(".header-search-button ").click();
//        $(byId("query-builder-test")).sendKeys("allure-example");

        sleep(SLEEPTIME);
        LOGGER.info("Sleeping {} secs...", SLEEPTIME/1000);

        $("#query-builder-test").sendKeys("allure-example");
        $("#query-builder-test").submit();

        $(byLinkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#74")).should(exist);
    }

    @Test
    @DisplayName("Search for issue with number 80")
    void searchForIssue1() {

        step("Open main page", () -> open("https://github.com"));

        sleep(SLEEPTIME);
        LOGGER.info("Sleeping {} secs...", SLEEPTIME/1000);

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

        sleep(SLEEPTIME);
        LOGGER.info("Sleeping {} secs...", SLEEPTIME/1000);

        steps.searchForRepository("allure-example");
        steps.openRepositoryByLink("eroshenkoam/allure-example");
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(80);

    }
}
