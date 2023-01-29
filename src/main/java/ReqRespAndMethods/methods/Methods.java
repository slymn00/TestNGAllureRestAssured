package ReqRespAndMethods.methods;

import ReqRespAndMethods.request.BySearch;
import base.ServiceCommons;
import data.GetData;
import data.Variables;
import org.apache.http.HttpStatus;

public class Methods extends ServiceCommons {

    public Methods searchMovie(String movieName){
        lib.get(GetData.Url.BASE_URI.getValue()+"?s="+movieName+"&apikey=e7adebce","getMovie");
        lib.checkStatusCode(HttpStatus.SC_OK);

        for (int i = 0; i <lib.response.jsonPath().getList("Search.Title").size() ; i++) {
            lib.control(lib.response.jsonPath().getString("Search.Title["+i+"]").contains("Harry Potter"),
                    "Movie Title "+movieName+" iceriyor. Title -> "+lib.response.jsonPath().getString("Search.Title["+i+"]"),
                    "Movie Title "+movieName+" icermiyor. Title -> "+lib.response.jsonPath().getString("Search.Title["+i+"]"));
        }
        return this;
    }

}
