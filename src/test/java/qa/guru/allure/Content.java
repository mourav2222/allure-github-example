package qa.guru.allure;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content {

    @SerializedName("content")
    private List<Launch> content;


    public List<Launch> getContent() {
        return content;
    }

}
