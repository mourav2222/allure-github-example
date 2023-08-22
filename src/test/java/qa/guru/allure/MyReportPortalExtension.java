package qa.guru.allure;

import com.epam.reportportal.junit5.ReportPortalExtension;
import com.epam.reportportal.service.Launch;
import com.epam.ta.reportportal.ws.model.launch.LaunchResource;
import io.reactivex.Maybe;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.epam.reportportal.junit5.ItemType.SUITE;

public class MyReportPortalExtension extends ReportPortalExtension {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyReportPortalExtension.class);

    @Override
    public void beforeAll(ExtensionContext context) {
//        super.beforeAll(context);

        Launch launch = getLaunch(context); // Trigger launch start
        String launchUuid = launch.getLaunch().blockingGet();
        LOGGER.info("Launch UUID: {}", launchUuid);

        Maybe<LaunchResource> launchResourceMaybe = launch.getClient().getLaunchByUuid(launch.getLaunch().blockingGet());
        Long launchNumber = launchResourceMaybe.blockingGet().getNumber();
        LOGGER.info("Launch Number: #{}", launchNumber);

        startTestItem(context, SUITE);
    }
}
