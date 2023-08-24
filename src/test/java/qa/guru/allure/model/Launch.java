package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Launch {
//    @SerializedName("owner")
    @JsonProperty(value = "owner")
    private String owner;

//    @SerializedName("description")
    @JsonProperty(value = "description")
    private String description;

//    @SerializedName("id")
    @JsonProperty(value = "id")
    private Long id;

//    @SerializedName("uuid")
    @JsonProperty(value = "uuid")
    private String uuid;

//    @SerializedName("name")
    @JsonProperty(value = "name")
    private String name;

//    @SerializedName("number")
    @JsonProperty(value = "number")
    private Long number;


    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Long getNumber() {
        return number;
    }
}
