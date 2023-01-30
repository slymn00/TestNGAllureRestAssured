package TestsOMDB;

import ReqRespAndMethods.methods.Methods;
import org.testng.annotations.Test;
import utils.TestListeners;

public class OMDB extends TestListeners {


    @Test
    public void controlIMDBRating(){
        startTest(new Methods())
                .searchMovie("Harry Potter")
                .findMovie("Harry Potter and the Deathly Hallows: Part 2")
                .checkImdbRating("8.1");
    }
}
