package ReqRespAndMethods.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ByID {


    @JsonProperty("i")
    private String i;

}
