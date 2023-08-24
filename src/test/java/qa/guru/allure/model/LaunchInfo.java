package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class LaunchInfo{
        @JsonProperty(value = "attributes")
        public List<Attribute> attributes;

        @JsonProperty(value = "description")
        public Description description;

        @JsonProperty(value = "ids")
        public List<Long> ids;


        public LaunchInfo(List<Attribute> attributes, Description description, List<Long> ids) {
                this.attributes = attributes;
                this.description = description;
                this.ids = ids;
        }

}
