package ReqRespAndMethods.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ByTitle {


    @JsonProperty("t")
    private String t;
}
