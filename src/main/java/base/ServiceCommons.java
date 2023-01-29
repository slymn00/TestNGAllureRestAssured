package base;

import data.GetData;
import data.Variables;

public class ServiceCommons extends ServiceBase {

    public static final ServiceCommons lib = new ServiceCommons();

    public final Variables variables=Variables.getInstance();

    public static final String BASE_URL= GetData.Url.BASE_URI.getValue();

    private static final ThreadLocal<ServiceCommons> libTL = new ThreadLocal<>();
    public static  ServiceCommons getLib() {
        if (libTL.get() == null) libTL.set(new ServiceCommons());
        return libTL.get();
    }


}
