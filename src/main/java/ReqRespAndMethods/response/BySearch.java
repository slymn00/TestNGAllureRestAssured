package ReqRespAndMethods.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BySearch {

    @JsonProperty("Title")
    private String Title;

    @JsonProperty("Year")
    private String Year;

    @JsonProperty("imdbID")
    private String imdbID;

    @JsonProperty("Type")
    private String Type;

    @JsonProperty("Poster")
    private String Poster;

}
