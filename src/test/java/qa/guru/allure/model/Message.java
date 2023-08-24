package qa.guru.allure.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty(value = "message")
    public String message;


    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


