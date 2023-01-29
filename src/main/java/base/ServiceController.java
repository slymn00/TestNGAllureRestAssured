package base;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.DataFinder;
import utils.Terminal;
import utils.TestListener;

@Listeners({TestListener.class})
public class ServiceController {

    public <T> T startTest(T page){
        ThreadLocal<T> tl = new ThreadLocal<>();
        tl.set(page);
        return tl.get();
    }


    @BeforeSuite
    public void removeReportHistory() {
        if (DataFinder.getValue("config", "deleteHistory").equals("true")) {
            Terminal.runCommand("cmd /c allure generate --clean --output allure-results");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void openAllureReport() {
        Terminal.runCommand("cmd /c allure serve -h localhost");
    }
}
