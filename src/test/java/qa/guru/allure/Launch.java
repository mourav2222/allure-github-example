package qa.guru.allure;

import com.google.gson.annotations.SerializedName;

public class Launch {
    @SerializedName("owner")
    private String owner;
    @SerializedName("description")
    private String description;
    @SerializedName("id")
    private Integer id;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("name")
    private String name;
    @SerializedName("number")
    private Integer number;

    public String getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }
}
