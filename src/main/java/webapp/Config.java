package webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.LogManager;


/**
 * Загрузка конфигурации
 */
public class Config {
    public static final String DIR_STORAGE;
    public static final String DB_URL, DB_USER, DB_PASSWORD;
    private static Object storage;

    static {
        String webappRoot = System.getenv("WEBAPP_ROOT");
        if (webappRoot == null) {
            throw new IllegalStateException("Define environment variable WEBAPP_ROOT");
        }
        File webappRootDir = new File(webappRoot);
        Properties props = new Properties();
        try (FileInputStream webappProps = new FileInputStream(new File(webappRootDir, "webapp.properties"));
             FileInputStream logProps = new FileInputStream(new File(webappRootDir, "logging.properties"))) {

            LogManager.getLogManager().readConfiguration(logProps);

            props.load(webappProps);
            DIR_STORAGE = props.getProperty("dir.storage");
            DB_URL = props.getProperty("db.url");
            DB_USER = props.getProperty("db.user");
            DB_PASSWORD = props.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public static Object getStorage() {
        return storage;
    }
}
