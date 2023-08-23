package qa.guru.allure;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class ReportPortalTest {

    private final String ACCESSTOKEN = "76939b7a-b187-4669-8917-311ac607087a";
    private final String BASEURL = "http://smrtcos8srv-4:9080/";

    private Retrofit createRetrofit(final String token, final String baseurl) {

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

        Retrofit retrofit = createRetrofit(ACCESSTOKEN, BASEURL);

        LaunchService service = retrofit.create(LaunchService.class);
        Call<Content> callSync = service.getContent("esm-guitests", 1);

        try {
            Response<Content> response = callSync.execute();
            Content content = response.body();
            List<Launch> launches = content.getContent();
            Integer number = launches.stream().findFirst().get().getNumber();
            System.out.println("Launch Number: #" + number);

            Assertions.assertEquals(580, number.intValue());

        } catch (Exception ex) {

            ex.printStackTrace();
            System.exit(1);

        }

    }

}
