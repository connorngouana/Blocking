package ie.atu.week5blockingappication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TodoResponse
{
   @JsonProperty("userID")
    private int userID;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("completed")
    private boolean completed;


}
