package qa.guru.allure;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class TestCmdExtension implements BeforeAllCallback {

    private final Logger logger = LoggerFactory.getLogger(TestCmdExtension.class);

    public static Optional<String> testpattern;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

        logger.info("Call beforeAll function...");

    }

}
