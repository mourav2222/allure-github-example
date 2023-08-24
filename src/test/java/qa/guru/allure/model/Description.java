package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Description {

    @JsonProperty(value = "action")
    public String action;

    @JsonProperty(value = "comment")
    public String comment;

    public Description(String action, String comment) {
        this.action = action;
        this.comment = comment;
    }
}
