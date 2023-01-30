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

    public Methods findMovie(String movieTitle) {

        for (int i = 0; i <lib.response.jsonPath().getList("Search.Title").size() ; i++) {
            if (lib.response.jsonPath().getString("Search.Title["+i+"]").equals(movieTitle)){
                variables.setMovieTitle(lib.response.jsonPath().getString("Search.Title["+i+"]"));
                variables.setImdbID(lib.response.jsonPath().getString("Search.imdbID["+i+"]"));
            }
        }

        return this;
    }

    public Methods checkImdbRating(String imdbRating) {
        lib.get(GetData.Url.BASE_URI.getValue()+"?i="+variables.getImdbID()+"&apikey="+variables.getApiKey(),"getMovie");
        lib.checkStatusCode(HttpStatus.SC_OK);

        lib.control(lib.response.jsonPath().getString("imdbRating").equals(imdbRating)
                ,"IMDB Rating sayilari dogrulandi."
                ,"IMDB Rating sayilari dogrulanamadi. Response'daki imdb rating -> "+lib.response.jsonPath().getString("imdbRating")+" Beklenen imdb rating -> "+ imdbRating);
        return this;
    }
}
