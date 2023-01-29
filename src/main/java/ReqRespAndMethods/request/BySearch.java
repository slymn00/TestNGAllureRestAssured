package ReqRespAndMethods.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BySearch {

    @JsonProperty("s")
    private String s;
}
