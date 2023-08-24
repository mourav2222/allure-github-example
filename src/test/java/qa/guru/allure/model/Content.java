package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Content {

//    @SerializedName("content")
    @JsonProperty(value = "content")
    private List<Launch> content;


    public List<Launch> getContent() {
        return content;
    }

}
