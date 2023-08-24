package qa.guru.allure.service;

import qa.guru.allure.model.Content;
import qa.guru.allure.model.LaunchBulk;
import qa.guru.allure.model.LaunchInfo;
import qa.guru.allure.model.Message;
import retrofit2.Call;
import retrofit2.http.*;

public interface LaunchService {

    @GET("/api/v1/{projectName}/launch/latest")
    Call<Content> getContent(
            @Path("projectName") String projectName,
            @Query("page.size") int pagesize);

    @PUT("/api/v1/{projectName}/launch/info")
    @Headers({"Content-Type: application/json", "accept: */*"})
    Call<Message> updateLaunch(
            @Path("projectName") String projectName,
            @Body LaunchInfo body);

    @PUT("/api/v1/{projectName}/launch/info")
    @Headers({"Content-Type: application/json", "accept: */*"})
    Call<Message> updateLaunchBulk(
            @Path("projectName") String projectName,
            @Body LaunchBulk body);

}
