package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;


    /* This method is used to initialize property file */
    public Properties init_prop() {

        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties");
            prop.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;

    }

    /* This method is used to read property from property file */
    public static String getConfigValue(String property) {
        prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties");
            prop.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(property);
    }

}
