package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Attribute {
    @JsonProperty(value = "action")
    public String action;
    @JsonProperty(value = "to")
    public To to;

    public Attribute(String action, To to) {
        this.action = action;
        this.to = to;
    }
}
