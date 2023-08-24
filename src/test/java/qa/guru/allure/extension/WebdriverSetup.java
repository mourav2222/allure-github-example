package qa.guru.allure.extension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebdriverSetup implements BeforeAllCallback, AfterAllCallback {

    static final Logger LOGGER = LoggerFactory.getLogger(WebdriverSetup.class);

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        LOGGER.info("Call beforeAll function...");

        String idea = System.getProperty("idea");
        System.out.println("idea: " + idea);

        if(!Boolean.valueOf(idea) && false) {
            Configuration.remote = "http://localhost:4444/wd/hub";
        }
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {

        LOGGER.info("Call afterAll function...");
//        SelenideLogger.removeListener("AllureSelenide");

    }


}
