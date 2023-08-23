package qa.guru.allure;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LaunchService {

    @GET("/api/v1/{projectName}/launch/latest")
    public Call<Content> getContent(
            @Path("projectName") String projectName,
            @Query("page.size") int pagesize);



}
