package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@JsonPropertyOrder({
        "attributes",
        "description",
        "ids"
})
public class LaunchBulk {

    @JsonProperty(value = "attributes")
    List<Attribute> attributes;

//    @JsonProperty(value = "description")
    @SerializedName("description")
    Description descriptionObject;

    @JsonProperty(value = "ids")
    List<Long> ids;


    // Constructor

    public LaunchBulk(List<Attribute> attributes, Description descriptionObject, List<Long> ids) {
        this.attributes = attributes;
        this.descriptionObject = descriptionObject;
        this.ids = ids;
    }

    public LaunchBulk() {

    }


    // Getter Methods

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public Description getDescription() {
        return descriptionObject;
    }

    // Setter Methods


    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public void setDescription(Description descriptionObject) {
        this.descriptionObject = descriptionObject;
    }

    public class Attribute {
        @JsonProperty(value = "action")
        public String action;
        @JsonProperty(value = "to")
        public To to;

        public Attribute(String action, To to) {
            this.action = action;
            this.to = to;
        }

        public Attribute() {

        }

        public class To {
            @JsonProperty(value = "key")
            public String key;

            @JsonProperty(value = "value")
            public String value;

            public To(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }
    }


    public class Description {

        @JsonProperty(value = "action")
        private String action;

        @JsonProperty(value = "comment")
        private String comment;

        public Description(String action, String comment) {
            this.action = action;
            this.comment = comment;
        }

        // Getter Methods

        public String getAction() {
            return action;
        }

        public String getComment() {
            return comment;
        }

        // Setter Methods

        public void setAction(String action) {
            this.action = action;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

}
