package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class DataFinder {

    private static final Map<String, Properties> fileList = new HashMap<>();

    private DataFinder() {
        throw new IllegalStateException("Utility class");
    }

    public static <T extends Enum<T>> String getUrl(T u) {

        return getValue("GetData", u.name());
    }

    public static <T extends Enum<T>> String getBaseUrl(T b) {
        return getValue("GetData", b.name());
    }

    public static String getValue(String key) {
        return getValue("GetData", key);
    }

    public static String getValue(String filePath, String key) {
        return getProp(filePath).getProperty(key);
    }


    private static Properties getProp(String filePath) {

        if (!fileList.containsKey(filePath)) {
            fileList.put(filePath, createProp(filePath));
        }
        return fileList.get(filePath);
    }

    private static Properties createProp(String filePath) {

        InputStream is = null;
        Properties prop = new Properties();
        try {
            is = ClassLoader.getSystemResourceAsStream(filePath + ".properties");
            prop.load(is);
        } catch (Exception e) {
            Log.fail(filePath + ".properties" + " dosyası bulunamadı! \n\n", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.fail("Dosya kapatılamadı! \n\n", e);
                }
            }
        }
        return prop;
    }
}
