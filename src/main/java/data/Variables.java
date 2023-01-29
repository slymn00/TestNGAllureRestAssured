package data;


import ReqRespAndMethods.response.BySearch;
import lombok.Data;

@Data
public class Variables {

    private static ThreadLocal<Variables> instance = new ThreadLocal<>();

    private final String apiKey="e7adebce";

    private Variables() {}

    public static Variables getInstance() {
        return instance.get();
    }

    public static void setUp() {
        instance.set(new Variables());
    }


    private BySearch bySearch;

    private String movieTitle;


}
