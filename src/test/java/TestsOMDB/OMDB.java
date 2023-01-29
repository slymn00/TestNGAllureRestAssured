package TestsOMDB;

import ReqRespAndMethods.methods.Methods;
import base.ServiceController;
import org.testng.annotations.Test;

public class OMDB extends ServiceController {


    @Test
    public void controlIMDBRating(){
        startTest(new Methods())
                .searchMovie("Harry Potter");
    }
}
