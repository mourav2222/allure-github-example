package qa.guru.allure.base;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.epam.reportportal.junit5.ReportPortalExtension;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import qa.guru.allure.extension.TestCmdExtension;
import qa.guru.allure.extension.WebdriverSetup;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@ExtendWith({TestCmdExtension.class, WebdriverSetup.class, TextReportExtension.class, ReportPortalExtension.class})
public abstract class BaseTest {

    final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @Step("Open main page-2216")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search for repository {repo}")
    public void searchForRepository(String repo) {
        step("Step1111", () -> {
            $(".header-search-button ").click();
            $("#query-builder-test").sendKeys(repo);
            $("#query-builder-test").submit();
        });
    }

    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("AllureSelenide");
    }
}
