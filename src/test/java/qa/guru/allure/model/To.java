package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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
