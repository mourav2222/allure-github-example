package qa.guru.allure.tests;

import com.epam.reportportal.junit5.ReportPortalExtension;
import com.epam.reportportal.listeners.ListenerParameters;
import com.epam.reportportal.service.ReportPortal;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.Test;
import qa.guru.allure.model.*;
import qa.guru.allure.service.LaunchService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportPortalTest {


    private Retrofit createRetrofit(final String baseurl, final String token) {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + token)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    @Test
    void getLaunchNumberTest() {

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://smrtcos8srv-4:9080/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
//                .build();

        ReportPortal rp = ReportPortalExtension.REPORT_PORTAL;
        ListenerParameters params = rp.getParameters();

        Retrofit retrofit = createRetrofit(params.getBaseUrl(), params.getApiKey());

        LaunchService service = retrofit.create(LaunchService.class);
        Call<Content> callSync = service.getContent("esm-guitests", 1);

        try {
            Response<Content> response = callSync.execute();
            Content content = response.body();
            List<Launch> launches = content.getContent();
            Launch launch = launches.stream().findFirst().get();

            Long number = launch.getNumber();
            System.out.println("Launch Number: #" + number);

            Long id = launch.getId();
            System.out.println("Launch ID: #" + id);

            assertEquals(580, number.intValue());

        } catch (Exception ex) {

            ex.printStackTrace();
            System.exit(1);

        }

    }

    @Test
    void updateLaunchTest() {

        ReportPortal rp = ReportPortalExtension.REPORT_PORTAL;
        ListenerParameters params = rp.getParameters();

        Retrofit retrofit = createRetrofit(params.getBaseUrl(), params.getApiKey());

        LaunchService service = retrofit.create(LaunchService.class);

        List<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute("CREATE", new To("Launch","#592")));

        Description description = new Description("CREATE", "DOLOJ SAMODERSCHAVIE!!!!");
        List<Long> ids = new ArrayList<Long>(Arrays.asList(1886L));

        LaunchInfo launchInfo = new LaunchInfo(attributes, description, ids);

        Call<Message> callSync = service.updateLaunch("esm-guitests", launchInfo);

        try {
            Response<Message> response = callSync.execute();

            System.out.println("Response code: " + response.code());

            // code 200
            if (response.isSuccessful()) {
                // Response OK
                Message message = response.body();

                System.out.println("Response code: " + response.code());

                System.out.println("Response message: " + message.getMessage());

            } else {
                switch(response.code()) {
                    case 404:
                        // not found resource
                        break;
                    case 500:
                        // server error
                        break;
                }

                // Error response
                ResponseBody errorBody = response.errorBody();
                try {
                    System.out.println("errorBody: " + errorBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            System.exit(1);

        }

        assertTrue(true);
    }


    @Test
    void updateLaunchBulkTest() {


        ReportPortal rp = ReportPortalExtension.REPORT_PORTAL;
        ListenerParameters params = rp.getParameters();

        Retrofit retrofit = createRetrofit(params.getBaseUrl(), params.getApiKey());

        LaunchService service = retrofit.create(LaunchService.class);

        LaunchBulk launchBulk = new LaunchBulk();

        LaunchBulk.Attribute attribute = launchBulk.new Attribute();

        List<LaunchBulk.Attribute> attributes = new ArrayList<>();
        attributes.add(launchBulk.new Attribute("CREATE", attribute.new To("Launch","#592")));

        LaunchBulk.Description description = launchBulk.new Description("CREATE", "DOLOJ SAMODERSCHAVIE!!!!");
        List<Long> ids = new ArrayList<Long>(Arrays.asList(1886L));

        LaunchBulk launchBulk2 = new LaunchBulk(attributes, description, ids);

        Call<Message> callSync = service.updateLaunchBulk("esm-guitests", launchBulk2);

        try {
            Response<Message> response = callSync.execute();

            System.out.println("Response code: " + response.code());

            // code 200
            if (response.isSuccessful()) {
                // Response OK
                Message message = response.body();

                System.out.println("Response code: " + response.code());

                System.out.println("Response message: " + message.getMessage());

            } else {
                switch(response.code()) {
                    case 404:
                        // not found resource
                        break;
                    case 500:
                        // server error
                        break;
                }

                // Error response
                ResponseBody errorBody = response.errorBody();
                try {
                    System.out.println("errorBody: " + errorBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();
            System.exit(1);

        }

        assertTrue(true);
    }

}
