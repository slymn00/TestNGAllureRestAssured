package utils;

import data.Variables;
import io.qameta.allure.Allure;
import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Objects;

public class TestListeners implements TestLifecycleListener {

    @Override
    public void beforeTestStop(TestResult result) {

        if (result.getStatus() == Status.FAILED || result.getStatus() == Status.BROKEN) {
            Allure.step(result.getName());
        }

    }

    /**
     * Her test başlamadan önce çalışacak metot.
     */
    @BeforeMethod
    public void initialize() {
        /// variable'ı set ederek yeni bir variable objesi oluşturur.
        Variables.setUp();
    }

    public <T> T startTest(T page){
        ThreadLocal<T> tl = new ThreadLocal<>();
        tl.set(page);
        return tl.get();
    }
    @BeforeSuite(alwaysRun = true)
    public void removeReportHistory() {
        if (Objects.equals(DataFinder.getValue("config", "deleteHistory"), "true")) {
            Terminal.runCommand("cmd /c allure generate --clean --output allure-results");
            //can be use underline command too
            //Terminal.runCommand("C:\\Program Files\\allure-2.19.0\\bin\\allure.bat generate allure-results -o C:\\Users\\wkkod\\IdeaProjects\\TestNGProject\\allure-results --clean");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void openAllureReport() {
        Terminal.runCommand("cmd /c allure serve -h localhost");
    }
}

