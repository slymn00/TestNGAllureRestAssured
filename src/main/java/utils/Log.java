package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import lombok.SneakyThrows;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Arrays;

public final class Log {

    // Initialize Log4j logs
    private static final Logger LOGGER =  LogManager.getLogger(Log.class);

    private Log() {}

    //Info Level Logs
    public static <T> void pass(T message) {
        Allure.step(message.toString(), Status.PASSED);
        LOGGER.info(message);
    }

    //Warn Level Logs
    public static <T> void warning(T message) {
        Allure.step(message.toString(), Status.BROKEN);
        LOGGER.warn(message);
    }

    public static void error(Exception e) {
        error(null, e);
    }

    public static <T> void error(T message) {
        error(message, new Exception((String) message));
    }

    @SneakyThrows
    public static <T> void error(T message, Exception e) {
        if (message != null) warning(message);
        throw e;
    }

    //Error Level Logs
    public static <T> void fail(T message) {
        fail(message,null);
    }

    public static <T> void fail(T message, Exception e) {
        String stackTrace = "";
        if (e != null)
            stackTrace = Arrays.toString(e.getStackTrace());
        Allure.step(message + stackTrace, Status.FAILED);
        LOGGER.error(message);
        Assert.fail(message.toString(), e);
    }

    public static <T> void fail(T expected, T actual, String message) {
        fail(expected, actual, message, null);
    }

    public static <T> void fail(T expected, T actual, String message, Exception e) {
        warning("Expected: " + expected);
        warning("Actual: " + actual);
        fail(message, e);
    }
}
